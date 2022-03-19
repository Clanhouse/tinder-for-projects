package com.tinderforprojects.tinder.model.skill;

import java.util.List;

public interface SkillService {

    List<Skill> findAll();

    Skill findById(Long id);

    Skill create(String name);

    Skill update(Long id, String name);

}
