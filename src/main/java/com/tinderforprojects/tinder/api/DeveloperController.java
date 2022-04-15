package com.tinderforprojects.tinder.api;

import com.tinderforprojects.tinder.model.achievement.dto.AchievementDTO;
import com.tinderforprojects.tinder.model.achievement.dto.AchievementMapper;
import com.tinderforprojects.tinder.model.developer.DeveloperService;
import com.tinderforprojects.tinder.model.developer.dto.DeveloperDTO;
import com.tinderforprojects.tinder.model.developer.dto.DeveloperMapper;
import com.tinderforprojects.tinder.model.photo.dto.PhotoDto;
import com.tinderforprojects.tinder.model.skill.dto.SkillDTO;
import com.tinderforprojects.tinder.model.skill.dto.SkillMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/developers")
public class DeveloperController {

    private final DeveloperService developerService;
    private final DeveloperMapper developerMapper;
    private final AchievementMapper achievementMapper;
    private final SkillMapper skillMapper;

    @GetMapping
    public List<DeveloperDTO> findAll() {
        return developerMapper.toDeveloperDTOs(
                developerService.findAll());
    }

    @GetMapping("/{id}")
    public DeveloperDTO findById(@PathVariable Long id) {
        return developerMapper.toDeveloperDTO(
                developerService.findById(id));
    }

    @GetMapping("/random/{projectId}")
    public DeveloperDTO findRandom(@PathVariable Long projectId) {
        return developerMapper.toDeveloperDTO(
                developerService.findRandom(projectId));
    }

    @PostMapping
    public DeveloperDTO create(@Valid @RequestBody DeveloperDTO developerDto) {
        return developerMapper.toDeveloperDTO(
                developerService.create(
                        developerMapper.toDeveloper(developerDto)));
    }

    @PutMapping("/{id}/personal")
    public DeveloperDTO updatePersonalInformation(@PathVariable Long id, @RequestBody @Valid DeveloperDTO developerDto) {
        return developerMapper.toDeveloperDTO(
                developerService.updatePersonalInformation(id, developerMapper.toDeveloper(developerDto)));
    }

    @PutMapping("/{id}/achievements")
    public DeveloperDTO updateAchievements(@PathVariable Long id, @RequestBody List<AchievementDTO> achievementsDto) {
        return developerMapper.toDeveloperDTO(
                developerService.updateAchievements(id, achievementMapper.toAchievements(achievementsDto)));
    }

    @PutMapping("/{id}/skills")
    public DeveloperDTO updateSkills(@PathVariable Long id, @RequestBody List<SkillDTO> skillsDto) {
        return developerMapper.toDeveloperDTO(
                developerService.updateSkills(id, skillMapper.toSkills(skillsDto)));
    }

    @GetMapping("/{id}/photos")
    public List<PhotoDto> findPhotosByDeveloperId(@PathVariable Long id) {
        return developerService.downloadPhotos(id);
    }

    @PutMapping("/{id}/photos")
    public ResponseEntity<String> uploadPhoto(@RequestBody byte[] image, @PathVariable Long id) {
        return developerService.uploadPhoto(image, id);
    }


}
