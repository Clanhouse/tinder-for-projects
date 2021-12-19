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
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> findAll(){
        List<ProjectDTO> projectDTOS = projectService.findAll();
        if(projectDTOS.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(projectDTOS, HttpStatus.OK);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> findById(@PathVariable Integer id){
        try{
            ProjectDTO projectDTO = projectService.findById(id);
            return new ResponseEntity<>(projectDTO, HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<ProjectDTO> create(@PathVariable Integer id, @RequestBody ProjectDTO projectDTO){
        try{
            projectService.create(id,projectDTO);
            return new ResponseEntity<>(projectDTO, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO> update(@PathVariable Integer id, @RequestBody ProjectDTO projectDTO){
        if(projectService.isExistById(projectDTO.getId())){
            try{
                projectService.create(id,projectDTO);
                return new ResponseEntity<>(projectDTO, HttpStatus.OK);
            }catch (Exception e){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }



}
