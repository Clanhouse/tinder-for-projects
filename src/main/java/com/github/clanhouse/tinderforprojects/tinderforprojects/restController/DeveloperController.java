package com.github.clanhouse.tinderforprojects.tinderforprojects.restController;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.DeveloperDto;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Developer;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Project;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Skill;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ResourceNotFoundException;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.DeveloperRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.SkillRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.TableToMatchRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class DeveloperController {

    private DeveloperService developerService;

    private DeveloperRepository developerRepository;

    private SkillRepository skillRepository;


    public DeveloperController(DeveloperService developerService, DeveloperRepository developerRepository, SkillRepository skillRepository) {
        this.developerService = developerService;
        this.developerRepository = developerRepository;
        this.skillRepository = skillRepository;
    }

    @RequestMapping("/addDev")
    public Developer addNewDeveloper(@RequestBody Developer developer){
        return developerService.saveDeveloper(developer);
    }

    @RequestMapping("/getDevById/{idDev}")
    public Optional<DeveloperDto> getDeveloperById(@PathVariable Integer idDev){
       return developerService.findDeveloperById(idDev);
    }
     @PostMapping("/addSkill/{idDev}")
    public Skill addSkillForDev(@PathVariable Integer idDev,@RequestBody Skill skill ){
        return developerService.addSkillForDev(idDev, skill);

    }
    @GetMapping("/getRandomDeveloper")
    public Developer getRandomDeveloper(){
        return developerService.findRandomDeveloper();
    }

    }

