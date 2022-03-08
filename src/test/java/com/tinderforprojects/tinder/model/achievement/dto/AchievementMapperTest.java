package com.tinderforprojects.tinder.model.achievement.dto;

import com.tinderforprojects.tinder.model.achievement.Achievement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AchievementMapperTest {

    @Autowired
    private AchievementMapper achievementMapper;

    @Test
    void shouldMappedAchievementDtoToAchievement(){
        //given
        AchievementDto achievementDto = AchievementDto.builder()
                .id(1L)
                .name("School")
                .build();
        Achievement achievementToCheck = Achievement.builder()
                .id(1L)
                .name("School")
                .build();
        //when
        Achievement achievement = achievementMapper.toAchievement(achievementDto);
        //then
        assertNotNull(achievement);
        assertEquals(achievement.getName(), achievementToCheck.getName());
        assertEquals(achievement.getId(), achievementToCheck.getId());
        assertInstanceOf(Achievement.class, achievement);

    }

    @Test
    void shouldMappedAchievementToAchievementDto(){
        //given
        Achievement achievement = Achievement.builder()
                .id(1L)
                .name("School")
                .build();
        AchievementDto achievementDtoToCheck = AchievementDto.builder()
                .id(1L)
                .name("School")
                .build();
        //when
        AchievementDto achievementDto = achievementMapper.toAchievementDto(achievement);
        //then
        assertNotNull(achievementDto);
        assertEquals(achievementDto.getName(), achievementDtoToCheck.getName());
        assertEquals(achievementDto.getId(), achievementDtoToCheck.getId());
        assertInstanceOf(AchievementDto.class, achievementDto);

    }

    @Test
    void shouldMappedListOfAchievementsToListOfAchievementsDto(){
        //given
        List<Achievement> achievements = Arrays.asList(
                Achievement.builder()
                        .id(1L)
                        .name("School")
                        .build(),
                Achievement.builder()
                        .id(2L)
                        .name("Certificate")
                        .build());
        List<AchievementDto> achievementsDtoToCheck = Arrays.asList(
                AchievementDto.builder()
                        .id(1L)
                        .name("School")
                        .build(),
                AchievementDto.builder()
                        .id(2L)
                        .name("Certificate")
                        .build());
        //when
        List<AchievementDto> achievementsDto = achievementMapper.toAchievementsDto(achievements);
        //then
        assertEquals(2, achievements.size());
        assertEquals(achievementsDtoToCheck.get(0).getName(), achievementsDto.get(0).getName());
        assertEquals(achievementsDtoToCheck.get(0).getId(), achievementsDto.get(0).getId());
        assertInstanceOf(AchievementDto.class, achievementsDto.get(0));

    }

    @Test
    void shouldMappedListOfAchievementsDtoToListOfAchievements(){
        //given
        List<AchievementDto> achievementsDto = Arrays.asList(
                AchievementDto.builder()
                        .id(1L)
                        .name("School")
                        .build(),
                AchievementDto.builder()
                        .id(2L)
                        .name("Certificate")
                        .build());
        List<Achievement> achievementsToCheck = Arrays.asList(
                Achievement.builder()
                        .id(1L)
                        .name("School")
                        .build(),
                Achievement.builder()
                        .id(2L)
                        .name("Certificate")
                        .build());
        //when
        List<Achievement> achievements = achievementMapper.toAchievements(achievementsDto);
        //then
        assertEquals(2, achievements.size());
        assertEquals(achievementsToCheck.get(0).getName(), achievements.get(0).getName());
        assertEquals(achievementsToCheck.get(0).getId(), achievements.get(0).getId());
        assertInstanceOf(Achievement.class, achievements.get(0));
    }

}