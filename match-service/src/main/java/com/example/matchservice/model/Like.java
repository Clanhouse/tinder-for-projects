package com.example.matchservice.model;

import javax.validation.constraints.NotNull;

public record Like(
        @NotNull
        Long developerId,
        @NotNull
        Long projectId) {
}
