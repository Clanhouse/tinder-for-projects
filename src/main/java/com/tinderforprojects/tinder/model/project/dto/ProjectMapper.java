package com.tinderforprojects.tinder.model.project.dto;

import com.tinderforprojects.tinder.model.benefit.dto.BenefitMapper;
import com.tinderforprojects.tinder.model.company.Company;
import com.tinderforprojects.tinder.model.company.dto.CompanyMapper;
import com.tinderforprojects.tinder.model.company.dto.CompanyToProjectDTO;
import com.tinderforprojects.tinder.model.developer.Developer;
import com.tinderforprojects.tinder.model.developer.dto.DeveloperToLikedProjectDTO;
import com.tinderforprojects.tinder.model.project.Project;
import com.tinderforprojects.tinder.model.skill.dto.SkillMapper;
import lombok.AllArgsConstructor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
