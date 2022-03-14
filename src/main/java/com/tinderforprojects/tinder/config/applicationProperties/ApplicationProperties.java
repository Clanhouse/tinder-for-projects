package com.tinderforprojects.tinder.config.applicationProperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("app.tfp.api")
public class ApplicationProperties {

    private String url;
}
