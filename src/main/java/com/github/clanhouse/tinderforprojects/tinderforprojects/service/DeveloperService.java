package com.github.clanhouse.tinderforprojects.tinderforprojects.service;

import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Developer;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.DeveloperRapository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeveloperService {
    @Autowired
    private DeveloperRapository developerRapository;

    public Developer getDeveloperById(int id){
        final Optional<Developer> developerById = developerRapository.findById(id);
        return developerById.get();
    }

    public Iterable<Developer> getAllDevelopers(){
        return developerRapository.findAll();
    }
}
