package com.github.clanhouse.tinderforprojects.tinderforprojects.service;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.company.CompanyDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    List<CompanyDTO> findAll();

    CompanyDTO findById(Integer id);

    CompanyDTO create(CompanyDTO companyDTO);

    boolean isExistById(Integer id);

}
