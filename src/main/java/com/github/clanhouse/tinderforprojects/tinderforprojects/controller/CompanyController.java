package com.github.clanhouse.tinderforprojects.tinderforprojects.controller;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.company.CompanyDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public List<CompanyDTO> findAll(){
        return companyService.findAll();
    }

    @GetMapping("/{id}")
    public CompanyDTO findById(@PathVariable Integer id){
        return companyService.findById(id);
    }

    @PostMapping
    public CompanyDTO create(@RequestBody CompanyDTO companyDTO){
        return companyService.create(companyDTO);
    }

    @PutMapping("/{id}")
    public CompanyDTO update(@PathVariable Integer id, @RequestBody String name){
        return companyService.update(id, name);
    }


}
