package com.tinderforprojects.tinder.model.achievement.dto;

import com.tinderforprojects.tinder.model.achievement.Achievement;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring")
public interface AchievementMapper {

    AchievementDTO toAchievementDTO(Achievement achievement);

    List<AchievementDTO> toAchievementDTOs(List<Achievement> achievements);

    @InheritInverseConfiguration(name = "toAchievementDTO")
    Achievement toAchievement(AchievementDTO achievementDTO);


    @InheritInverseConfiguration(name = "toAchievementDTOs")
    List<Achievement> toAchievements(List<AchievementDTO> achievementsDTO);

}
