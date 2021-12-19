package com.github.clanhouse.tinderforprojects.tinderforprojects.controller;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.achievement.AchievementDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.AchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/achievement")
public class AchievementController {

    private final AchievementService achievementService;

    @GetMapping
    public List<AchievementDTO> findAll(){
        return achievementService.findAll();
    }

    @GetMapping("/{id}")
    public AchievementDTO findById(@PathVariable Integer id){
        return achievementService.findById(id);
    }

    @PostMapping
    public AchievementDTO create(@RequestBody AchievementDTO achievementDTO){
        return achievementService.create(achievementDTO);
    }

    @PutMapping("/{id}")
    public AchievementDTO update(@PathVariable Integer id, @RequestBody String name){
        return achievementService.update(id, name);
    }

}
