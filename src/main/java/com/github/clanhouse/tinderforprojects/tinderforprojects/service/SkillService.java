package com.github.clanhouse.tinderforprojects.tinderforprojects.service;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.skill.SkillDTO;

import java.util.List;

public interface SkillService {
    List<SkillDTO> findAll();
    SkillDTO findById(Integer id);
    SkillDTO create(SkillDTO skillDTO);
    boolean isExistById(Integer id);
}
