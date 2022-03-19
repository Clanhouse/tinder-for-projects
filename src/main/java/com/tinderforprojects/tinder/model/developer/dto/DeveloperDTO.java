package com.tinderforprojects.tinder.model.developer.dto;

import com.tinderforprojects.tinder.model.achievement.dto.AchievementDTO;
import com.tinderforprojects.tinder.model.photo.dto.PhotoDto;
import com.tinderforprojects.tinder.model.skill.dto.SkillDTO;
import lombok.*;

import java.util.List;

@Data
public class DeveloperDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String description;
    private String profession;
    private List<AchievementDTO> achievements;
    private List<SkillDTO> skills;
    private List<PhotoDto> photos;

}
