package com.tinderforprojects.tinder.model.user;


import com.tinderforprojects.tinder.model.user.dto.UserDto;
import com.tinderforprojects.tinder.model.user.dto.UserLoginDto;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    String login(UserLoginDto userLoginDto);

    String refreshToken(String token);

    Object findUserByUserName(String username);
}
