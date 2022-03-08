package com.tinderforprojects.tinder.model.developer.dto;

import com.tinderforprojects.tinder.model.achievement.dto.AchievementDto;
import com.tinderforprojects.tinder.model.photo.dto.PhotoDto;
import com.tinderforprojects.tinder.model.project.dto.ProjectToDeveloperDto;
import com.tinderforprojects.tinder.model.skill.dto.SkillDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@Setter
@ToString
public class DeveloperDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String description;
    private String profession;
    private List<AchievementDto> achievementsDto;
    private List<SkillDto> skillsDto;
    private List<PhotoDto> photosDto;
    private List<ProjectToDeveloperDto> likedProjects;
}
