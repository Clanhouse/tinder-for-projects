package com.tinderforprojects.tinder.model.achievement.dto;

import com.tinderforprojects.tinder.model.achievement.Achievement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AchievementMapper {

   public Achievement toAchievement(AchievementDto achievementDto) {
        return Achievement.builder()
                .id(achievementDto.getId())
                .name(achievementDto.getName())
                .build();
    }

    public AchievementDto toAchievementDto(Achievement achievement) {
        return AchievementDto.builder()
                .id(achievement.getId())
                .name(achievement.getName())
                .build();
    }

    public List<Achievement> toAchievements(List<AchievementDto> achievementsDto) {
        List<Achievement> achievements = new ArrayList<>();
        for (AchievementDto achievementDto : achievementsDto) {
            achievements.add(toAchievement(achievementDto));
        }
        return achievements;
    }

    public List<AchievementDto> toAchievementsDto(List<Achievement> achievements){
        List<AchievementDto> achievementsDto = new ArrayList<>();
        for(Achievement achievement : achievements){
            achievementsDto.add(toAchievementDto(achievement));
        }
        return achievementsDto;
    }

}
