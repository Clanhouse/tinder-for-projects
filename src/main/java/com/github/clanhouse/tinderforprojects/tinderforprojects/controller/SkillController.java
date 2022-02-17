package com.github.clanhouse.tinderforprojects.tinderforprojects.controller;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.skill.SkillDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/skills")
public class SkillController {

    private final SkillService skillService;

    @GetMapping
    public List<SkillDTO> findAll(){
       return skillService.findAll();
    }

    @GetMapping("/{id}")
    public SkillDTO findById(@PathVariable Integer id){
        return skillService.findById(id);
    }

    @PostMapping
    public SkillDTO create(@RequestBody SkillDTO skillDTO){
       return skillService.create(skillDTO);
    }

    @PutMapping("/{id}")
    public SkillDTO update(@PathVariable Integer id, @RequestBody String name){
        return skillService.update(id, name);
    }

}
