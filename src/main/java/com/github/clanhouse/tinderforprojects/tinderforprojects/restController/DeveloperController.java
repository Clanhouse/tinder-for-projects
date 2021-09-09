package com.github.clanhouse.tinderforprojects.tinderforprojects.restController;

import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Developer;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
public class DeveloperController {
    private DeveloperRepository developerRepository;

    @Autowired
    public DeveloperController(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }
    @RequestMapping("/addDev")
    public Developer addNewDeveloper(@RequestBody Developer developer){
        return developerRepository.save(developer);
    }
    @RequestMapping("/getDevById/{idDev}")
    public Optional<Developer> getDeveloperById(@PathVariable Integer idDev){
       return developerRepository.findById(idDev);
    }
}
