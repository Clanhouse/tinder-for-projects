package com.example.userservice.dto;

import com.example.userservice.model.AccountType;

public record UserResponse(
        Long id,
        String keycloakId,
        String userName,
        String email,
        String firstName,
        String lastName,
        AccountType accountType
) {
}
