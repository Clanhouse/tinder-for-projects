package com.tinderforprojects.tinder.model.project.dto;

import com.tinderforprojects.tinder.model.benefit.dto.BenefitDTO;
import com.tinderforprojects.tinder.model.company.dto.CompanyToLikedProjectDTO;
import com.tinderforprojects.tinder.model.skill.dto.SkillDTO;
import lombok.*;

import java.util.List;

@Data
public class ProjectToLikedProjectDTO {

    private int id;
    private String name;
    private String description;
    private List<SkillDTO> skills;
    private List<BenefitDTO> benefits;
    private CompanyToLikedProjectDTO company;

}
