package com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.developer.DeveloperDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.project.ProjectDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.likedProject.ProjectToLikedProjectDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Developer;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Project;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeveloperMapper {

    DeveloperDTO toDeveloperDTO(Developer developer);

    ProjectToLikedProjectDTO toProjectDTO(Project project);

    List<DeveloperDTO> toDeveloperDTOs(List<Developer> developers);

    List<ProjectToLikedProjectDTO> toProjectDTOs(List<Project> projects);

    @InheritInverseConfiguration(name = "toDeveloperDTO")
    Developer toDeveloper(DeveloperDTO developerDTO);

    @InheritInverseConfiguration(name = "toProjectDTO")
    Project toProject(ProjectDTO projectDTO);

}
