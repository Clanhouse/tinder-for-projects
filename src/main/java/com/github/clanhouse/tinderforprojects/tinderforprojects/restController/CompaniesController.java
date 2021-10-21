package com.github.clanhouse.tinderforprojects.tinderforprojects.restController;

import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Company;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.CompanyRepository;

import com.github.clanhouse.tinderforprojects.tinderforprojects.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
public class CompaniesController {

   private CompanyService companyService;

   @Autowired
    public CompaniesController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/addCompany")
    public Company addCompany(@Valid @RequestBody Company company) {
       return companyService.saveCompany(company);
    }

    @GetMapping("/getCompanyById/{idCompany}")
    public Optional<Company> getCompanyById(@PathVariable Integer idCompany){
        return companyService.findCompanyById(idCompany);
    }


}
