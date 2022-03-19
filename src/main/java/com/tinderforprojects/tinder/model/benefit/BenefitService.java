package com.tinderforprojects.tinder.model.benefit;

import java.util.List;

public interface BenefitService {

    List<Benefit> findAll();

    Benefit findById(Long id);

    Benefit create(String name);

    Benefit update(Long id, String name);

}
