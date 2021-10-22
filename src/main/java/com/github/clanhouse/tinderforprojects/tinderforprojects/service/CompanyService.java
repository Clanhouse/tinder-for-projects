package com.github.clanhouse.tinderforprojects.tinderforprojects.service;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.CompanyDto;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Company;

import java.util.Optional;

public interface CompanyService {

    Optional<CompanyDto> findCompanyById(Integer idCompany);

    Company saveCompany(Company company);
}
