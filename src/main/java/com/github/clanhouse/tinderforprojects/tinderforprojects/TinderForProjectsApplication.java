package com.github.clanhouse.tinderforprojects.tinderforprojects;

import com.github.clanhouse.tinderforprojects.tinderforprojects.config.properties.ApiProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties(ApiProperties.class)
public class TinderForProjectsApplication {


    public static void main(String[] args) {
        SpringApplication.run(TinderForProjectsApplication.class, args);
    }

}
