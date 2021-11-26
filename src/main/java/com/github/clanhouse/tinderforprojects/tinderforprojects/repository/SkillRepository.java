package com.github.clanhouse.tinderforprojects.tinderforprojects.repository;

import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
}
