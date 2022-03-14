package com.tinderforprojects.tinder.api;

import com.tinderforprojects.tinder.model.company.CompanyService;
import com.tinderforprojects.tinder.model.company.dto.CompanyDto;
import com.tinderforprojects.tinder.model.company.dto.CompanyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {
    
    private final CompanyService companyService;
    private final CompanyMapper companyMapper;

    @GetMapping
    public List<CompanyDto> findAll() {
        return companyMapper.toCompaniesDto(
                companyService.findAll());
    }

    @GetMapping("/{id}")
    public CompanyDto findById(@PathVariable Long id) {
        return companyMapper.toCompanyDto(
                companyService.findById(id));
    }

    @PostMapping
    public CompanyDto create(@RequestBody CompanyDto companyDto) {
        return companyMapper.toCompanyDto(
                companyService.create(
                        companyMapper.toCompany(companyDto)
                ));
    }

    @PutMapping("/{id}")
    public CompanyDto update(@PathVariable Long id, @RequestBody String name) {
        return companyMapper.toCompanyDto(
                companyService.update(id, name));
    }
    
}
