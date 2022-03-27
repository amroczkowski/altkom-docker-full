package pl.altkom.docker.account.configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.classmate.TypeResolver;

import lombok.RequiredArgsConstructor;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@RequiredArgsConstructor
public class SwaggerConfiguration {

    private final TypeResolver resolver;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("pl.altkom.docker.account.controller"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .globalResponseMessage(RequestMethod.GET, prepareGlobalResponseMessages())
                .globalResponseMessage(RequestMethod.POST, prepareGlobalResponseMessages())
                .globalResponseMessage(RequestMethod.DELETE, prepareGlobalResponseMessages())
                .globalResponseMessage(RequestMethod.PATCH, prepareGlobalResponseMessages())
                .globalOperationParameters(List.of());
    }

    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder().docExpansion(DocExpansion.LIST).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API - Account service")
                .description("Documentation of account service")
                .version(DocumentationType.SWAGGER_2.getVersion())
                .build();
    }

    private List<ResponseMessage> prepareGlobalResponseMessages() {
        return Arrays.asList(
                new ResponseMessageBuilder()
                        .code(HttpStatus.OK.value())
                        .message("OK")
                        .build()
        );
    }
}
