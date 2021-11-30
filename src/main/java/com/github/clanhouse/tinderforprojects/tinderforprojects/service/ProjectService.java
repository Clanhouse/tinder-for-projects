package com.github.clanhouse.tinderforprojects.tinderforprojects.service;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.project.ProjectDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {

    ProjectDTO create(Integer companyId, ProjectDTO projectDTO);

    ProjectDTO findById(Integer id);

    List<ProjectDTO> findAll();

    boolean isExistById(Integer id);


}
