package com.tinderforprojects.tinder.model.company;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();

    Company findById(Long id);

    Company create(Company company);

    Company update(Long id, String name);
}
