package pl.altkom.docker.account.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "paths")
public class PathsConfiguration {

    private String pictures;
}
