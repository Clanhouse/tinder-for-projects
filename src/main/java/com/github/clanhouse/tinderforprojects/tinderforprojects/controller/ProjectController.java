package com.github.clanhouse.tinderforprojects.tinderforprojects.controller;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.benefit.BenefitDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.project.ProjectDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.skill.SkillDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.ProjectService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Data
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public List<ProjectDTO> findAll() {
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public ProjectDTO findById(@PathVariable Integer id) {
        return projectService.findById(id);
    }


    @PostMapping("/{id}")
    public ProjectDTO create(@PathVariable Integer id, @RequestBody ProjectDTO projectDTO) {
        return projectService.create(id, projectDTO);
    }

    @GetMapping("/random/{developerId}")
    public ProjectDTO random(@PathVariable Integer developerId){
        return projectService.findRandom(developerId);
    }

    @PutMapping("/{id}/basic")
    public ProjectDTO updateBasicInformation(@PathVariable Integer id, @RequestBody ProjectDTO projectDTO) {
        return projectService.updateBasicInformation(id, projectDTO);

    }

    @PutMapping("/{id}/skills")
    public ProjectDTO updateSkills(@PathVariable Integer id, @RequestBody List<SkillDTO> skillDTOs) {
        return projectService.updateSkills(id, skillDTOs);
    }

    @PutMapping("/{id}/benefits")
    public ProjectDTO updateBenefits(@PathVariable Integer id, @RequestBody List<BenefitDTO> benefitDTOs) {
        return projectService.updateBenefits(id, benefitDTOs);
    }


}
