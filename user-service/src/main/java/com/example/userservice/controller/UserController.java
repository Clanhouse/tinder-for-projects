package com.example.userservice.controller;

import com.example.userservice.dto.CreateUserRequest;
import com.example.userservice.dto.UserResponse;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponse create(@RequestBody CreateUserRequest userRequest) {
        log.info("UserRequest: {}", userRequest);
        return userService.create(userRequest);
    }
    @GetMapping("/{userName}")
    public UserResponse findByUsername(@PathVariable String userName) {
        log.info("Find by userName request: {}", userName);
        return userService.findByUserName(userName);
    }
}
