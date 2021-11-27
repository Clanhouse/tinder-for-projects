package com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.company;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.benefit.BenefitDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.skill.SkillDTO;
import lombok.Data;

import java.util.List;

@Data
public class ProjectToCompanyDTO {

    private int id;
    private String name;
    private List<SkillDTO> skills;
    private List<BenefitDTO> benefits;

}
