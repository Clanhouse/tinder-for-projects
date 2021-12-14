package com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.project;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.benefit.BenefitDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.skill.SkillDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.likedProject.DeveloperToLikedProjectDTO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class ProjectDTO {

    private int id;
    @NotBlank
    @Size(min = 3, message = "Name must have at least 3 characters")
    private String name;
    private String description;
    private List<SkillDTO> skills;
    private List<BenefitDTO> benefits;
    private CompanyToProjectDTO company;
    private List<DeveloperToLikedProjectDTO> likedDevelopers;

}
