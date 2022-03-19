package com.tinderforprojects.tinder.model.skill.dto;

import com.tinderforprojects.tinder.model.skill.Skill;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
