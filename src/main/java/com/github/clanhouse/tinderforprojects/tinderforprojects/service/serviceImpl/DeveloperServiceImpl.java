package com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl;

import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Developer;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.DeveloperRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.SkillRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    private DeveloperRepository developerRepository;

    private SkillRepository skillRepository;

    @Autowired
    public DeveloperServiceImpl(DeveloperRepository developerRepository, SkillRepository skillRepository) {
        this.developerRepository = developerRepository;
        this.skillRepository = skillRepository;
    }


    @Override
    public Developer saveDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }

    @Override
    public Optional<Developer> findDeveloperById(Integer idDeveloper) {
        return developerRepository.findById(idDeveloper);
    }

    @Override
    public Developer findRandomDeveloper() {
        return developerRepository.getFirstRandomDeveloper();
    }

}
