package com.github.clanhouse.tinderforprojects.tinderforprojects.service;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.developer.DeveloperDTO;

import java.util.List;

public interface DeveloperService {

    DeveloperDTO create(DeveloperDTO developerDTO);

    DeveloperDTO findById(Integer id);

    DeveloperDTO findRandom();

    List<DeveloperDTO> findAll();

    DeveloperDTO update(DeveloperDTO developerDTO);




}
