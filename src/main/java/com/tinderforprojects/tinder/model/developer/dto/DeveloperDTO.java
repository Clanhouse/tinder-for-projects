package com.tinderforprojects.tinder.model.developer.dto;

import com.tinderforprojects.tinder.model.achievement.dto.AchievementDTO;
import com.tinderforprojects.tinder.model.skill.dto.SkillDTO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class DeveloperDTO {

    private Long id;
    @NotBlank
    @Size(min = 3, message = "First name must have at least 3 characters")
    private String firstName;
    @NotBlank
    @Size(min = 3, message = "Last name must have at least 3 characters")
    private String lastName;
    private String description;
    private String profession;
    private List<AchievementDTO> achievements;
    private List<SkillDTO> skills;

}
