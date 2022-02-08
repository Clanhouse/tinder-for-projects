package com.github.clanhouse.tinderforprojects.tinderforprojects.controller;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.project.ProjectDTO;
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
    public List<ProjectDTO> findAll(){
        return projectService.findAll();
    }
    @GetMapping("/{id}")
    public ProjectDTO findById(@PathVariable Integer id){
       return projectService.findById(id);
    }

    @PostMapping("/{id}")
    public ProjectDTO create(@PathVariable Integer companyId, @RequestBody ProjectDTO projectDTO){
      return projectService.create(companyId,projectDTO);
    }



}
