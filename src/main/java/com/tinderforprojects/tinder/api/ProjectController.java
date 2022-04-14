package com.tinderforprojects.tinder.api;

import com.tinderforprojects.tinder.model.benefit.dto.BenefitDTO;
import com.tinderforprojects.tinder.model.benefit.dto.BenefitMapper;
import com.tinderforprojects.tinder.model.photo.PhotoService;
import com.tinderforprojects.tinder.model.photo.dto.PhotoDto;
import com.tinderforprojects.tinder.model.project.ProjectService;
import com.tinderforprojects.tinder.model.project.dto.ProjectDTO;
import com.tinderforprojects.tinder.model.project.dto.ProjectMapper;
import com.tinderforprojects.tinder.model.skill.dto.SkillDTO;
import com.tinderforprojects.tinder.model.skill.dto.SkillMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectMapper projectMapper;
    private final SkillMapper skillMapper;
    private final BenefitMapper benefitMapper;
    private final PhotoService photoService;

    @GetMapping
    public List<ProjectDTO> findAll() {
        return projectMapper.toProjectDTOs(
                projectService.findAll());
    }

    @GetMapping("/{id}")
    public ProjectDTO findById(@PathVariable Long id) {
        return projectMapper.toProjectDTO(
                projectService.findById(id));
    }

    @GetMapping("/random/{developerId}")
    public ProjectDTO random(@PathVariable Long developerId) {
        return projectMapper.toProjectDTO(
                projectService.findRandom(developerId));
    }

    @PostMapping
    public ProjectDTO create(@RequestBody ProjectDTO projectDto) {
        return projectMapper.toProjectDTO(
                projectService.create(
                        projectMapper.toProject(projectDto)));
    }

    @PutMapping("/{id}/basic")
    public ProjectDTO updateBasicInformation(@PathVariable Long id, @RequestBody ProjectDTO projectDto) {
        return projectMapper.toProjectDTO(
                projectService.updateBasicInformation(id, projectMapper.toProject(projectDto)));
    }

    @PutMapping("/{id}/skills")
    public ProjectDTO updateSkills(@PathVariable Long id, @RequestBody List<SkillDTO> skillsDto) {
        return projectMapper.toProjectDTO(
                projectService.updateSkills(id, skillMapper.toSkills(skillsDto)));
    }

    @PutMapping("/{id}/benefits")
    public ProjectDTO updateBenefits(@PathVariable Long id, @RequestBody List<BenefitDTO> benefitsDto) {
        return projectMapper.toProjectDTO(
                projectService.updateBenefits(id, benefitMapper.toBenefits(benefitsDto)));
    }

    @PutMapping("/{id}/photos")
    public ResponseEntity<String> uploadPhoto(@RequestBody byte[] image, @PathVariable Long id) {
        return projectService.uploadPhoto(image, id);
    }

    @GetMapping("/{id}/photos")
    public List<PhotoDto> getPhotosByProjectId(@PathVariable Long id){
        return projectService.downloadPhotos(id);
    }

}
