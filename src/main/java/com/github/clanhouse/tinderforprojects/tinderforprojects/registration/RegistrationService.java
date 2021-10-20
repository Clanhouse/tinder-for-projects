package com.github.clanhouse.tinderforprojects.tinderforprojects.registration;

import com.github.clanhouse.tinderforprojects.tinderforprojects.applicationUser.ApplicationUser;
import com.github.clanhouse.tinderforprojects.tinderforprojects.applicationUser.ApplicationUserService;
import com.github.clanhouse.tinderforprojects.tinderforprojects.applicationUser.UsersRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {


    private final ApplicationUserService applicationUserService;
    private final EmailValidation emailValidation;

    public String register(RegistrationRequest registrationRequest) {
        boolean isEmailValid = emailValidation.test(registrationRequest.getEmail());
        if (!isEmailValid) {
            throw new IllegalStateException("Email is not valid!");
        }

        return applicationUserService.signUpUser(new ApplicationUser(
                registrationRequest.getFirstName(),
                registrationRequest.getLastName(),
                registrationRequest.getEmail(),
                registrationRequest.getPassword(),
                UsersRole.USER
        ));
    }
}
