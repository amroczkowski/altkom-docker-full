package pl.altkom.docker.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import pl.altkom.docker.account.configuration.PathsConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableConfigurationProperties({PathsConfiguration.class})
@EnableSwagger2
@SpringBootApplication
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

}
