package com.github.clanhouse.tinderforprojects.tinderforprojects.service;

import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Company;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

public Company getCompanyById(int id){
    final Optional<Company> companyById = companyRepository.findById(id);
    return companyById.get();
}
public Iterable<Company> getAllCompanies(){
    return companyRepository.findAll();
}
}
