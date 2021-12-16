package com.github.clanhouse.tinderforprojects.tinderforprojects.service;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.benefit.BenefitDTO;

import java.util.List;

public interface BenefitService {

    List<BenefitDTO> findAll();
    BenefitDTO findById(Integer id);
    BenefitDTO create(BenefitDTO benefitDTO);
    BenefitDTO update(Integer id, String name);

}
