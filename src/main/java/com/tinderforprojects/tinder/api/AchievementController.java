package com.tinderforprojects.tinder.api;

import com.tinderforprojects.tinder.model.achievement.AchievementService;
import com.tinderforprojects.tinder.model.achievement.dto.AchievementDTO;
import com.tinderforprojects.tinder.model.achievement.dto.AchievementMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/achievements")
@RequiredArgsConstructor
public class AchievementController {

    private final AchievementService achievementService;
    private final AchievementMapper achievementMapper;

    @GetMapping
    public List<AchievementDTO> findAll() {
        return achievementMapper.toAchievementDTOs(
                achievementService.findAll());
    }

    @GetMapping("/{id}")
    public AchievementDTO findById(@PathVariable Long id) {
        return achievementMapper.toAchievementDTO(
                achievementService.findById(id));
    }

    @PostMapping
    public AchievementDTO create(@RequestBody @Valid String name) {
        return achievementMapper.toAchievementDTO(
                achievementService.create(name));
    }

    @PutMapping("/{id}")
    public AchievementDTO update(@PathVariable Long id, @RequestBody @Valid String name) {
        return achievementMapper.toAchievementDTO(
                achievementService.update(id, name));
    }

}
