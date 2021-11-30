package com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.likedProject.DeveloperToLikedProjectDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.project.CompanyToProjectDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.project.ProjectDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Company;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Developer;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Project;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectDTO toProjectDTO(Project project);

    DeveloperToLikedProjectDTO toDeveloperDTO(Developer developer);

    CompanyToProjectDTO toCompanyDTO(Company company);

    List<DeveloperToLikedProjectDTO> toDeveloperDTOs(List<Developer> developers);

    List<ProjectDTO> toProjectDTOs(List<Project> projects);

    @InheritInverseConfiguration(name = "toProjectDTO")
    Project toProject(ProjectDTO projectDTO);

    @InheritInverseConfiguration(name = "toProjectDTOs")
    List<Project> toProjects(List<ProjectDTO> projectDTOs);

}
