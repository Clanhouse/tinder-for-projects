package com.github.clanhouse.tinderforprojects.tinderforprojects.service;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.achievement.AchievementDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.developer.DeveloperDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.skill.SkillDTO;

import java.util.List;

public interface DeveloperService {

    DeveloperDTO create(DeveloperDTO developerDTO);

    DeveloperDTO findById(Integer id);

    DeveloperDTO findRandom(Integer projectId);

    List<DeveloperDTO> findAll();

    DeveloperDTO updatePersonalInformation(Integer id, DeveloperDTO developerDTO);

    DeveloperDTO updateAchievements(Integer id, List<AchievementDTO> achievementDTOs);

    DeveloperDTO updateSkills(Integer id, List<SkillDTO> skillDTOs);




}
