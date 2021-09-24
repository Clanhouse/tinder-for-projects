package com.github.clanhouse.tinderforprojects.tinderforprojects.restController;

import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Project;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ResourceNotFoundException;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.CompanyRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ProjectController {

    private CompanyRepository companyRepository;

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectController(CompanyRepository companyRepository, ProjectRepository projectRepository) {
        this.companyRepository = companyRepository;
        this.projectRepository = projectRepository;
    }


    @PostMapping("/addProject/{idCompany}")
    public Project addProjectForCompany(@Validated @RequestBody Project project, @PathVariable Integer idCompany) {
        return companyRepository.findById(idCompany).map(company -> {
            project.setCompany(company);
            return projectRepository.save(project);
        }).orElseThrow(() -> new ResourceNotFoundException("idCompany " + idCompany + " not found"));

    }

    @GetMapping("/getProjectById/{idProject}")
    public Optional<Project> getProjectById(@PathVariable Integer idProject){
       return projectRepository.findById(idProject);
    }


}
