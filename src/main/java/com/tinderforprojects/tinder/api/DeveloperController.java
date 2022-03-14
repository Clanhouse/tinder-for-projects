package com.tinderforprojects.tinder.api;

import com.tinderforprojects.tinder.model.achievement.dto.AchievementDto;
import com.tinderforprojects.tinder.model.achievement.dto.AchievementMapper;
import com.tinderforprojects.tinder.model.developer.DeveloperService;
import com.tinderforprojects.tinder.model.developer.dto.DeveloperDto;
import com.tinderforprojects.tinder.model.developer.dto.DeveloperMapper;
import com.tinderforprojects.tinder.model.match.TableToMatchService;
import com.tinderforprojects.tinder.model.project.dto.ProjectMapper;
import com.tinderforprojects.tinder.model.skill.dto.SkillDto;
import com.tinderforprojects.tinder.model.skill.dto.SkillMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/developers")
public class DeveloperController {

    private final DeveloperService developerService;
    private final DeveloperMapper developerMapper;
    private final TableToMatchService tableToMatchService;
    private final ProjectMapper projectMapper;
    private final AchievementMapper achievementMapper;
    private final SkillMapper skillMapper;

    @GetMapping
    public List<DeveloperDto> findAll() {
        List<DeveloperDto> developersDto = developerMapper.toDevelopersDto(developerService.findAll());
        for(DeveloperDto developerDto : developersDto) {
            developerDto.setLikedProjects(projectMapper.toProjectsToDeveloperDto(tableToMatchService.findAllLikedProjectsByDeveloperId(developerDto.getId())));
        }
        return developersDto;
    }

    @GetMapping("/{id}")
    public DeveloperDto findById(@PathVariable Long id) {
        DeveloperDto developerDto = developerMapper.toDeveloperDto(developerService.findById(id));
        developerDto.setLikedProjects(projectMapper.toProjectsToDeveloperDto(tableToMatchService.findAllLikedProjectsByDeveloperId(developerDto.getId())));
        return developerDto;
    }

    @GetMapping("/random/{projectId}")
    public DeveloperDto findRandom(@PathVariable Long projectId) {
        return developerMapper.toDeveloperDto(developerService.findRandom(projectId));
    }

    @PostMapping
    public DeveloperDto create(@RequestBody DeveloperDto developerDto) {
        return developerMapper.toDeveloperDto(developerService.create(developerMapper.toDeveloper(developerDto)));
    }

    @PutMapping("/{id}/personal")
    public DeveloperDto updatePersonalInformation(@PathVariable Long id, @RequestBody DeveloperDto developerDto) {
        return developerMapper.toDeveloperDto(developerService.updatePersonalInformation(id, developerMapper.toDeveloper(developerDto)));
    }

    @PutMapping("/{id}/achievements")
    public DeveloperDto updateAchievements(@PathVariable Long id, @RequestBody List<AchievementDto> achievementsDto) {
        return developerMapper.toDeveloperDto(developerService.updateAchievements(id, achievementMapper.toAchievements(achievementsDto)));
    }

    @PutMapping("/{id}/skills")
    public DeveloperDto updateSkills(@PathVariable Long id, @RequestBody List<SkillDto> skillsDto) {
        return developerMapper.toDeveloperDto(developerService.updateSkills(id, skillMapper.toSkills(skillsDto)));
    }



}
