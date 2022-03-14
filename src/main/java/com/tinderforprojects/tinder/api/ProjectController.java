package com.tinderforprojects.tinder.api;

import com.tinderforprojects.tinder.model.benefit.dto.BenefitDto;
import com.tinderforprojects.tinder.model.benefit.dto.BenefitMapper;
import com.tinderforprojects.tinder.model.developer.dto.DeveloperMapper;
import com.tinderforprojects.tinder.model.match.TableToMatchService;
import com.tinderforprojects.tinder.model.project.ProjectService;
import com.tinderforprojects.tinder.model.project.dto.ProjectDto;
import com.tinderforprojects.tinder.model.project.dto.ProjectMapper;
import com.tinderforprojects.tinder.model.skill.dto.SkillDto;
import com.tinderforprojects.tinder.model.skill.dto.SkillMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectMapper projectMapper;
    private final DeveloperMapper developerMapper;
    private final SkillMapper skillMapper;
    private final BenefitMapper benefitMapper;
    private final TableToMatchService tableToMatchService;

    @GetMapping
    public List<ProjectDto> findAll() {
        List<ProjectDto> projectsDto = projectMapper.toProjectsDto(projectService.findAll());
        for(ProjectDto projectDto : projectsDto) {
            projectDto.setLikedDevelopers(developerMapper.toDevelopersToProjectDto(tableToMatchService.findAllLikedDevelopersByProjectId(projectDto.getId())));
        }
        return projectsDto;
    }

    @GetMapping("/{id}")
    public ProjectDto findById(@PathVariable Long id) {
        ProjectDto projectDto = projectMapper.toProjectDto(projectService.findById(id));
        projectDto.setLikedDevelopers(developerMapper.toDevelopersToProjectDto(tableToMatchService.findAllLikedDevelopersByProjectId(projectDto.getId())));
        return projectDto;
    }

    @GetMapping("/random/{developerId}")
    public ProjectDto random(@PathVariable Long developerId) {
        return projectMapper.toProjectDto(projectService.findRandom(developerId));
    }

    @PostMapping
    public ProjectDto create(@RequestBody ProjectDto projectDto) {
        return projectMapper.toProjectDto(projectService.create(projectMapper.toProject(projectDto)));
    }

    @PutMapping("/{id}/basic")
    public ProjectDto updateBasicInformation(@PathVariable Long id, @RequestBody ProjectDto projectDto) {
        return projectMapper.toProjectDto(projectService.updateBasicInformation(id, projectMapper.toProject(projectDto)));
    }

    @PutMapping("/{id}/skills")
    public ProjectDto updateSkills(@PathVariable Long id, @RequestBody List<SkillDto> skillsDto) {
        return projectMapper.toProjectDto(projectService.updateSkills(id, skillMapper.toSkills(skillsDto)));
    }

    @PutMapping("/{id}/benefits")
    public ProjectDto updateBenefits(@PathVariable Long id, @RequestBody List<BenefitDto> benefitsDto) {
        return projectMapper.toProjectDto(projectService.updateBenefits(id, benefitMapper.toBenefits(benefitsDto)));
    }

}
