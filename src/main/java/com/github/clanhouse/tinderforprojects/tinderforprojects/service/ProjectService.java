package com.github.clanhouse.tinderforprojects.tinderforprojects.service;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.ProjectDto;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Project;

import java.util.Optional;

public interface ProjectService {

    Project addProjectForCompany(Project project, Integer idCompany);

    Optional<ProjectDto> getProjectById(Integer id);


}
