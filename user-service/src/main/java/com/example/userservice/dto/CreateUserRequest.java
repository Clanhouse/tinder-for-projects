package com.example.userservice.dto;

import com.example.userservice.model.AccountType;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record CreateUserRequest(
        @NotEmpty
        String userName,
        @NotEmpty
        String email,
        @NotEmpty
        String password,
        @NotEmpty
        String firstName,
        @NotEmpty
        String lastName,
        @NotNull
        AccountType accountType
) {
}
