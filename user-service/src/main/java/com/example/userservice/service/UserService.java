package com.example.userservice.service;

import com.example.userservice.dto.CreateUserRequest;
import com.example.userservice.dto.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserResponse create(CreateUserRequest user);

    UserResponse findByUserName(String username);

}
