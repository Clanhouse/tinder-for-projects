package com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.achievement.AchievementDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Achievement;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

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
