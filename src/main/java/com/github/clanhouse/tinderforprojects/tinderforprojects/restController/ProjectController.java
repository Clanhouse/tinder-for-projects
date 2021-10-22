package com.github.clanhouse.tinderforprojects.tinderforprojects.restController;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.ProjectDto;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Project;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ResourceNotFoundException;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.CompanyRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.ProjectRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.ProjectService;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/addProject/{idCompany}")
    public Project addProjectForCompany(@Validated @RequestBody Project project, @PathVariable Integer idCompany) {
        return projectService.addProjectForCompany(project, idCompany);
    }

    @GetMapping("/getProjectById/{idProject}")
    public Optional<ProjectDto> getProjectById(@PathVariable Integer idProject){
       return projectService.getProjectById(idProject);
    }


}
