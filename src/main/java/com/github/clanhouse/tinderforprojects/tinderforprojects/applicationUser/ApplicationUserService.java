package com.github.clanhouse.tinderforprojects.tinderforprojects.applicationUser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserRepository applicationUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return applicationUserRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Wrong email or username"));
    }

    public String signUpUser(ApplicationUser applicationUser) {
        boolean userIsPresent = applicationUserRepository.findByEmail(applicationUser.getEmail()).isPresent();
        if (userIsPresent) {
            throw new IllegalStateException("Email already exists");
        }
        String encodeThePassword = bCryptPasswordEncoder.encode(applicationUser.getPassword());
        applicationUser.setPassword(encodeThePassword);
        applicationUserRepository.save(applicationUser);
        //i need to do sending confiormation token
        return "hoply it works";
    }
}
