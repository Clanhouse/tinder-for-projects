package com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.developer;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.achievement.AchievementDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.skill.SkillDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.likedProject.ProjectToLikedProjectDTO;
import lombok.Data;

import java.util.List;

@Data
public class DeveloperDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String description;
    private List<AchievementDTO> achievements;
    private List<SkillDTO> skills;
    private List<ProjectToLikedProjectDTO> likedProjects;

}
