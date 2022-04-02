package com.tinderforprojects.tinder.model.user;

import com.tinderforprojects.tinder.config.security.Credentials;
import com.tinderforprojects.tinder.config.security.KeycloakConfig;
import com.tinderforprojects.tinder.model.developer.Developer;
import com.tinderforprojects.tinder.model.developer.DeveloperService;
import com.tinderforprojects.tinder.model.user.dto.UserDto;
import com.tinderforprojects.tinder.model.user.dto.UserLoginDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.tinderforprojects.tinder.config.security.KeycloakConfig.getInstance;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final DeveloperService developerService;

    @Override
    public UserDto createUser(UserDto userDto) {

        UserRepresentation user = getUserRepresentation(userDto);
        UsersResource userResource = getInstance();
        Response response = userResource.create(user);
        if (response.getStatus() != 201) {
            log.error(String.format("Error while creating user. Auth server response details: \n status: %d, message: %s ",
                    response.getStatus(), response.getStatusInfo()));
            throw new ResponseStatusException(HttpStatus.valueOf(response.getStatus()));
        }

        developerService.create(Developer.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .user(User.builder()
                        .id(CreatedResponseUtil.getCreatedId(response))
                        .build())
                .build());

        log.info("User created");

        return userDto;

    }

    @Override
    public String login(UserLoginDto userLoginDto) {
        //TODO
        //Move it to encrypted config file
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id", "tinder-app");
        map.add("client_secret", "3Nqsg1frENrbSWBpnvYOEGcgCpsB0aMy");
        map.add("username",userLoginDto.getUserName());
        map.add("password",userLoginDto.getPassword());
        map.add("grant_type", "password");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
        ResponseEntity<String> exchange = restTemplate.exchange(
                "https://tinder-auth.cytr.us/auth/realms/tinder/protocol/openid-connect/token",
                HttpMethod.POST,
                entity,
                String.class);
        return exchange.getBody();

    }

    @Override
    public String refreshToken(String token) {
        //TODO
        //Move it to encrypted config file
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id", "tinder-app");
        map.add("client_secret", "3Nqsg1frENrbSWBpnvYOEGcgCpsB0aMy");
        map.add("refresh_token", token);
        map.add("grant_type", "refresh_token");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
        ResponseEntity<String> exchange = restTemplate.exchange(
                "https://tinder-auth.cytr.us/auth/realms/tinder/protocol/openid-connect/token",
                HttpMethod.POST,
                entity,
                String.class);
        return exchange.getBody();
    }

    @Override
    public Object findUserByUserName(String username) {
        return developerService.findByUserId(
                getInstance().search(username,true).get(0).getId());
    }

    private UserRepresentation getUserRepresentation(UserDto userDto) {

        CredentialRepresentation credential = Credentials
                .createPasswordCredentials(userDto.getPassword());

        UserRepresentation user = new UserRepresentation();

        user.setUsername(userDto.getUserName());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmailId());
        user.setCredentials(Collections.singletonList(credential));
        user.setRealmRoles(Arrays.asList("app-user"));
        user.setEnabled(true);

        return user;
    }

    private UsersResource getInstance() {
        return KeycloakConfig.getInstance().realm(KeycloakConfig.realm).users();
    }
}
