package com.tinderforprojects.tinder.api;

import com.tinderforprojects.tinder.model.achievement.AchievementService;
import com.tinderforprojects.tinder.model.achievement.dto.AchievementDto;
import com.tinderforprojects.tinder.model.achievement.dto.AchievementMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/achievements")
@RequiredArgsConstructor
public class AchievementController {

    private final AchievementService achievementService;
    private final AchievementMapper achievementMapper;

    @GetMapping
    public List<AchievementDto> findAll() {
        return achievementMapper.toAchievementsDto(
                achievementService.findAll());
    }

    @GetMapping("/{id}")
    public AchievementDto findById(@PathVariable Long id) {
        return achievementMapper.toAchievementDto(
                achievementService.findById(id));
    }

    @PostMapping
    public AchievementDto create(@RequestBody String name) {
        return achievementMapper.toAchievementDto(
                achievementService.create(name));
    }

    @PutMapping("/{id}")
    public AchievementDto update(@PathVariable Long id, @RequestBody String name) {
        return achievementMapper.toAchievementDto(
                achievementService.update(id, name));
    }

}
