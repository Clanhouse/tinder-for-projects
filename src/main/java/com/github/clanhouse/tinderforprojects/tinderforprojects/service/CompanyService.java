package com.github.clanhouse.tinderforprojects.tinderforprojects.service;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.company.CompanyDTO;

import java.util.List;


public interface CompanyService {

    List<CompanyDTO> findAll();

    CompanyDTO findById(Integer id);

    CompanyDTO create(CompanyDTO companyDTO);

    boolean isExistById(Integer id);

}
