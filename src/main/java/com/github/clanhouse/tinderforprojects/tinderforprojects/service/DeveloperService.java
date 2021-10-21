package com.github.clanhouse.tinderforprojects.tinderforprojects.service;

import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Developer;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Skill;

import java.util.Optional;

public interface DeveloperService {

    Developer saveDeveloper(Developer developer);

    Optional<Developer> findDeveloperById(Integer idDeveloper);

    Developer findRandomDeveloper();


}
