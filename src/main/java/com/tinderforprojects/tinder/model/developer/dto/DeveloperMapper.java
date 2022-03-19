package com.tinderforprojects.tinder.model.developer.dto;

import com.tinderforprojects.tinder.model.achievement.dto.AchievementMapper;
import com.tinderforprojects.tinder.model.developer.Developer;
import com.tinderforprojects.tinder.model.project.Project;
import com.tinderforprojects.tinder.model.project.dto.ProjectDTO;
import com.tinderforprojects.tinder.model.project.dto.ProjectToLikedProjectDTO;
import com.tinderforprojects.tinder.model.skill.dto.SkillMapper;
import lombok.AllArgsConstructor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
