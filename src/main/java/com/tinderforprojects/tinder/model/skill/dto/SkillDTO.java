package com.tinderforprojects.tinder.model.skill.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class SkillDTO {

    private Long id;
    @NotBlank
    @Size(min = 3, message = "Name must have at least 3 characters")
    private String name;

}
