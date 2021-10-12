package com.github.clanhouse.tinderforprojects.tinderforprojects.restController;

import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Company;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
public class CompaniesController {

    private CompanyRepository companyRepository;

    @Autowired
    public CompaniesController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @PostMapping("/addCompany")
    public Company addCompany(@Valid @RequestBody Company company) {
       return companyRepository.save(company);
    }

    @GetMapping("/getCompanyById/{idCompany}")
    public Optional<Company> getCompanyById(@PathVariable Integer idCompany){
        return companyRepository.findById(idCompany);
    }


}
