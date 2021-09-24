package com.github.clanhouse.tinderforprojects.tinderforprojects.registration;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationService {
    public String register(RegistrationRequest registrationRequest) {
    return "ok";
    }
}
