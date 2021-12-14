package com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.developer;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.achievement.AchievementDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.skill.SkillDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.likedProject.ProjectToLikedProjectDTO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class DeveloperDTO {

    private int id;
    @NotBlank
    @Size(min = 3, message = "Name must have at least 3 characters")
    private String firstName;
    @NotBlank
    @Size(min = 3, message = "Lastname must have at least 3 characters")
    private String lastName;
    private String description;
    private String profession;
    private List<AchievementDTO> achievements;
    private List<SkillDTO> skills;
    private List<ProjectToLikedProjectDTO> likedProjects;

}
