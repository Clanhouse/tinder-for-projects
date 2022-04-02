package com.tinderforprojects.tinder.api;

import com.tinderforprojects.tinder.model.developer.Developer;
import com.tinderforprojects.tinder.model.developer.dto.DeveloperMapper;
import com.tinderforprojects.tinder.model.user.UserService;
import com.tinderforprojects.tinder.model.user.dto.UserDto;
import com.tinderforprojects.tinder.model.user.dto.UserLoginDto;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final DeveloperMapper developerMapper;

    @PostMapping("/create")
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginDto userLoginDto) {
        return userService.login(userLoginDto);
    }

    @PostMapping("/refreshToken")
    public String refreshToken(@RequestBody String token) {
        return userService.refreshToken(token);
    }

    @GetMapping("/{userName}")
    public Object findUser(@PathVariable String userName) {
        return developerMapper.toDeveloperDTO((Developer) userService.findUserByUserName(userName));
    }

}
