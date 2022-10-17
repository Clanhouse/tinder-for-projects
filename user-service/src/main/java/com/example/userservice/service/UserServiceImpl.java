package com.example.userservice.service;

import com.example.userservice.config.security.CredentialsConfig;
import com.example.userservice.config.security.KeycloakConfig;
import com.example.userservice.dto.CreateUserRequest;
import com.example.userservice.dto.UserResponse;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.utils.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private static final String REALM_USER_ROLE_NAME = "user";
    private static final String REALM_NAME = "dev";
    private final UsersResource keycloakUserResource = getInstance();

    @Override
    public UserResponse create(CreateUserRequest userRequest) {
        val user = getUserRepresentation(userRequest);

        val response = keycloakUserResource.create(user);
        if (response.getStatus() != 201) {
            log.error("Cannot create user. Auth server response details: {}", response.getStatusInfo());
            throw new ResponseStatusException(HttpStatus.valueOf(response.getStatus()));
        }
        val keycloakId = CreatedResponseUtil.getCreatedId(response);
        //TODO save to developer/company DB(service) ? Now or later after registration?
        val id = saveToDb(userRequest, keycloakId).getId();

        return new UserResponse(
                id,
                keycloakId,
                userRequest.userName(),
                userRequest.email(),
                userRequest.firstName(),
                userRequest.lastName(),
                userRequest.accountType());
    }

    @Override
    public UserResponse findByUserName(String username) {
        //TODO get userDetails from develop/company DB?
        val user = userRepository.findByUsername(username);
        //TODO exception
        return UserMapper.toResponse(user.get());
    }


    private User saveToDb(CreateUserRequest userRequest, String keycloakId) {
        val user = User.builder()
                .keycloakId(keycloakId)
                .username(userRequest.userName())
                .email(userRequest.email())
                .firstName(userRequest.firstName())
                .lastName(userRequest.lastName())
                .accountType(userRequest.accountType())
                .build();
        log.info("Save userToDb request: {}", user);
        return userRepository.save(user);
    }

    private UserRepresentation getUserRepresentation(CreateUserRequest userRequest) {
        val credentials = CredentialsConfig.createPasswordCredentials(userRequest.password());
        val user = new UserRepresentation();

        user.setUsername(userRequest.userName());
        user.setFirstName(userRequest.firstName());
        user.setLastName(userRequest.lastName());
        user.setEmail(userRequest.email());
        user.setCredentials(Collections.singletonList(credentials));
        user.setRealmRoles(List.of(REALM_USER_ROLE_NAME));
        user.setEnabled(true);

        return user;
    }

    private UsersResource getInstance() {
        return KeycloakConfig.getInstance().realm(REALM_NAME).users();
    }
}
