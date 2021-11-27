package com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.likedProject;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.benefit.BenefitDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.skill.SkillDTO;
import lombok.Data;

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
