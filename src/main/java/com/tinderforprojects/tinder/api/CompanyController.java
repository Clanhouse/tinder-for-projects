package com.tinderforprojects.tinder.api;

import com.tinderforprojects.tinder.model.company.CompanyService;
import com.tinderforprojects.tinder.model.company.dto.CompanyDTO;
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
    public List<CompanyDTO> findAll() {
        return companyMapper.toCompanyDTOs(
                companyService.findAll());
    }

    @GetMapping("/{id}")
    public CompanyDTO findById(@PathVariable Long id) {
        return companyMapper.toCompanyDTO(
                companyService.findById(id));
    }

    @PostMapping
    public CompanyDTO create(@RequestBody CompanyDTO companyDto) {
        return companyMapper.toCompanyDTO(
                companyService.create(
                        companyMapper.toCompany(companyDto)
                ));
    }

    @PutMapping("/{id}")
    public CompanyDTO update(@PathVariable Long id, @RequestBody String name) {
        return companyMapper.toCompanyDTO(
                companyService.update(id, name));
    }
    
}
