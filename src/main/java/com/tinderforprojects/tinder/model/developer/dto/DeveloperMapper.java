package com.tinderforprojects.tinder.model.developer.dto;

import com.tinderforprojects.tinder.model.achievement.dto.AchievementMapper;
import com.tinderforprojects.tinder.model.developer.Developer;
import com.tinderforprojects.tinder.model.skill.dto.SkillMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DeveloperMapper {

    private final AchievementMapper achievementMapper;
    private final SkillMapper skillMapper;


    public Developer toDeveloper(DeveloperDto developerDto) {
        return Developer.builder()
                .id(developerDto.getId())
                .firstName(developerDto.getFirstName())
                .lastName(developerDto.getLastName())
                .description(developerDto.getDescription())
                .profession(developerDto.getProfession())
                .achievements(achievementMapper.toAchievements(developerDto.getAchievementsDto()))
                .skills(skillMapper.toSkills(developerDto.getSkillsDto()))
                .build();
    }

    public DeveloperDto toDeveloperDto(Developer developer) {
        return DeveloperDto.builder()
                .id(developer.getId())
                .firstName(developer.getFirstName())
                .lastName(developer.getLastName())
                .description(developer.getDescription())
                .profession(developer.getProfession())
                .achievementsDto(achievementMapper.toAchievementsDto(developer.getAchievements()))
                .skillsDto(skillMapper.toSkillsDto(developer.getSkills()))
                .likedProjects(new ArrayList<>())
                .photosDto(new ArrayList<>())
                .build();
    }

    public List<Developer> toDevelopers(List<DeveloperDto> developersDto) {
        List<Developer> developers = new ArrayList<>();
        for(DeveloperDto developerDto : developersDto) {
            developers.add(toDeveloper(developerDto));
        }
        return developers;
    }

    public List<DeveloperDto> toDevelopersDto(List<Developer> developers) {
        List<DeveloperDto> developersDto = new ArrayList<>();
        for(Developer developer : developers) {
            developersDto.add(toDeveloperDto(developer));
        }
        return developersDto;
    }

    public DeveloperToProjectDto toDeveloperToProjectDto(Developer developer) {
        return DeveloperToProjectDto.builder()
                .id(developer.getId())
                .firstName(developer.getFirstName())
                .lastName(developer.getLastName())
                .description(developer.getDescription())
                .profession(developer.getProfession())
                .achievementsDto(achievementMapper.toAchievementsDto(developer.getAchievements()))
                .skillsDto(skillMapper.toSkillsDto(developer.getSkills()))
                .photosDto(new ArrayList<>())
                .build();
    }

    public List<DeveloperToProjectDto> toDevelopersToProjectDto(List<Developer> developers) {
        List<DeveloperToProjectDto> developersToProjectDto = new ArrayList<>();
        for (Developer developer : developers) {
            developersToProjectDto.add(toDeveloperToProjectDto(developer));
        }
        return developersToProjectDto;
    }




}
