package com.github.clanhouse.tinderforprojects.tinderforprojects.service;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.achievement.AchievementDTO;

import java.util.List;

public interface AchievementService {

    List<AchievementDTO> findAll();
    AchievementDTO findById(Integer id);
    AchievementDTO create(AchievementDTO achievementDTO);
    boolean isExistById(Integer id);

}
