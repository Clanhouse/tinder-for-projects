package com.github.clanhouse.tinderforprojects.tinderforprojects.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("app.tfp.api")
public class ApiProperties {

    private String url;
}
