package com.tinderforprojects.tinder.api;


import com.tinderforprojects.tinder.model.skill.SkillService;
import com.tinderforprojects.tinder.model.skill.dto.SkillDTO;
import com.tinderforprojects.tinder.model.skill.dto.SkillMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/skills")
public class SkillController {

    private final SkillService skillService;
    private final SkillMapper skillMapper;

    @GetMapping
    public List<SkillDTO> findAll() {
        return skillMapper.toSkillDTOs(
                skillService.findAll());
    }

    @GetMapping("/{id}")
    public SkillDTO findById(@PathVariable Long id) {
        return skillMapper.toSkillDTO(
                skillService.findById(id));
    }

    @PostMapping
    public SkillDTO create(@RequestBody String name) {
        return skillMapper.toSkillDTO(
                skillService.create(name));
    }

    @PutMapping("/{id}")
    public SkillDTO update(@PathVariable Long id, @RequestBody String name) {
        return skillMapper.toSkillDTO(
                skillService.update(id, name));
    }
}
