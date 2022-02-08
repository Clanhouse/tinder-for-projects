package com.github.clanhouse.tinderforprojects.tinderforprojects.controller;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.developer.DeveloperDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/developers")
public class DeveloperController {

    private final DeveloperService developerService;

    @GetMapping
    public List<DeveloperDTO> findAll(){
        return developerService.findAll();
    }

    @GetMapping("/{id}")
    public DeveloperDTO findById(@PathVariable Integer id){
        return developerService.findById(id);
    }

    @GetMapping("/random")
    public DeveloperDTO findRandom(){
        return developerService.findRandom();
    }

    @PostMapping
    public DeveloperDTO create(@RequestBody DeveloperDTO developerDTO){
        return developerService.create(developerDTO);
    }

    @PutMapping
    public DeveloperDTO update(@RequestBody DeveloperDTO developerDTO){
        return developerService.update(developerDTO);
    }


    }

