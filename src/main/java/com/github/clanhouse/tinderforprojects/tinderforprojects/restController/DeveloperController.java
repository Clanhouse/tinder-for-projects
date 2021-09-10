package com.github.clanhouse.tinderforprojects.tinderforprojects.restController;

import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Developer;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Project;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Skill;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ResourceNotFoundException;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.DeveloperRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class DeveloperController {
    private DeveloperRepository developerRepository;

    private SkillRepository skillRepository;

    @Autowired
    public DeveloperController(DeveloperRepository developerRepository, SkillRepository skillRepository) {
        this.developerRepository = developerRepository;
        this.skillRepository = skillRepository;
    }

    @RequestMapping("/addDev")
    public Developer addNewDeveloper(@RequestBody Developer developer){
        return developerRepository.save(developer);
    }
    @RequestMapping("/getDevById/{idDev}")
    public Optional<Developer> getDeveloperById(@PathVariable Integer idDev){
       return developerRepository.findById(idDev);
    }
     @PostMapping("/addSkill/{idDev}")
    public Skill addSkillForDev(@PathVariable Integer idDev,@RequestBody Skill skill ){
        return developerRepository.findById(idDev).map(dev -> {
            skill.setDev(Collections.singletonList(dev));
            return skillRepository.save(skill);
        }).orElseThrow(() -> new ResourceNotFoundException("idCompany " + idDev + " not found"));

    }

    }

