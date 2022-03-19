package com.tinderforprojects.tinder.model.achievement.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AchievementDTO {

    private Long id;
    @NotBlank
    @Size(min = 3, message = "Name must have at least 3 characters")
    private String name;

}
