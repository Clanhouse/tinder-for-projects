package com.tinderforprojects.tinder.model.developer.dto;

import com.tinderforprojects.tinder.model.achievement.dto.AchievementDTO;
import com.tinderforprojects.tinder.model.skill.dto.SkillDTO;
import lombok.*;

import java.util.List;

@Data
public class DeveloperToLikedProjectDTO {

    private int id;

    private String firstName;
    private String lastName;
    private String description;
    private List<AchievementDTO> achievements;
    private List<SkillDTO> skills;

}
