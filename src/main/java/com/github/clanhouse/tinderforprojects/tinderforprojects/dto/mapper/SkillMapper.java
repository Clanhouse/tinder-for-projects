package com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.skill.SkillDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Skill;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SkillMapper {

    SkillDTO toSkillDTO(Skill skill);

    List<SkillDTO> toSkillDTOs(List<Skill> skills);

    @InheritInverseConfiguration(name = "toSkillDTOs")
    List<Skill> toSkills(List<SkillDTO> skillDTOS);

    @InheritInverseConfiguration(name = "toSkillDTO")
    Skill toSkill(SkillDTO skillDTO);

}
