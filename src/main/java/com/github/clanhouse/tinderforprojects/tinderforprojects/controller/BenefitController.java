package com.github.clanhouse.tinderforprojects.tinderforprojects.controller;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.benefit.BenefitDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.BenefitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/benefit")
public class BenefitController {

    private final BenefitService benefitService;

    @GetMapping
    public List<BenefitDTO> findAll(){
        return benefitService.findAll();
    }

    @GetMapping("/{id}")
    public BenefitDTO findById(@PathVariable Integer id){
        return benefitService.findById(id);
    }

    @PostMapping
    public BenefitDTO create(@RequestBody BenefitDTO benefitDTO){
        return benefitService.create(benefitDTO);
    }

    @PutMapping("/{id}")
    public BenefitDTO update(@PathVariable Integer id, @RequestBody String name){
        return benefitService.update(id, name);
    }
}
