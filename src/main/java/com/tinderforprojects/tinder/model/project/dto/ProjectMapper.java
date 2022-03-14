package com.tinderforprojects.tinder.model.project.dto;

import com.tinderforprojects.tinder.model.benefit.dto.BenefitMapper;
import com.tinderforprojects.tinder.model.project.Project;
import com.tinderforprojects.tinder.model.skill.dto.SkillMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ProjectMapper {

    private final SkillMapper skillMapper;
    private final BenefitMapper benefitMapper;

    public ProjectDto toProjectDto(Project project) {
        return ProjectDto.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .skills(skillMapper.toSkillsDto(project.getSkills()))
                .benefits(benefitMapper.toBenefitsDto(project.getBenefits()))
                .likedDevelopers(new ArrayList<>())
                .build();
    }

    public Project toProject(ProjectDto projectDto) {
        return Project.builder()
                .id(projectDto.getId())
                .name(projectDto.getName())
                .description(projectDto.getDescription())
                .skills(skillMapper.toSkills(projectDto.getSkills()))
                .benefits(benefitMapper.toBenefits(projectDto.getBenefits()))
                .build();
    }

    public ProjectToDeveloperDto projectToDeveloperDto(Project project) {
        return ProjectToDeveloperDto.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .benefits(benefitMapper.toBenefitsDto(project.getBenefits()))
                .skills(skillMapper.toSkillsDto(project.getSkills()))
                .build();
    }

    public List<ProjectToDeveloperDto> toProjectsToDeveloperDto(List<Project> projects) {
        List<ProjectToDeveloperDto> projectsToDeveloperDto = new ArrayList<>();
        for (Project project : projects) {
            projectsToDeveloperDto.add(projectToDeveloperDto(project));
        }
        return projectsToDeveloperDto;
    }


    public ProjectToCompanyDto toProjectToCompanyDto(Project project) {
        return ProjectToCompanyDto.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .benefits(benefitMapper.toBenefitsDto(project.getBenefits()))
                .skills(skillMapper.toSkillsDto(project.getSkills()))
                .build();
    }

    public List<ProjectToCompanyDto> toProjectsToCompanyDto(List<Project> projects) {
        List<ProjectToCompanyDto> projectsToCompanyDto = new ArrayList<>();
        for (Project project : projects) {
            projectsToCompanyDto.add(toProjectToCompanyDto(project));
        }
        return projectsToCompanyDto;
    }

    public List<ProjectDto> toProjectsDto(List<Project> projects) {
        List<ProjectDto> projectsDto = new ArrayList<>();
        for(Project project : projects) {
            projectsDto.add(toProjectDto(project));
        }
        return projectsDto;
    }

}
