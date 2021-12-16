package com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper.AchievementMapper;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.achievement.AchievementDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ControllerError;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ControllerException;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.AchievementRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.AchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AchievementServiceImpl implements AchievementService {

    private final AchievementRepository achievementRepository;
    private final AchievementMapper achievementMapper;

    @Override
    public List<AchievementDTO> findAll() {
        List<AchievementDTO> achievements = achievementMapper.toAchievementDTOs(achievementRepository.findAll());
        if(achievements.isEmpty()) throw new ControllerException(ControllerError.EMPTY);
        return achievements;
    }

    @Override
    public AchievementDTO findById(Integer id) {
        return achievementMapper.toAchievementDTO(achievementRepository.findById(id)
                .orElseThrow(() -> new ControllerException(ControllerError.NOT_FOUND)));
    }

    @Override
    public AchievementDTO create(AchievementDTO achievementDTO) {
        if(isExistByName(achievementDTO.getName())) throw new ControllerException(ControllerError.EXISTS);
        return achievementMapper.toAchievementDTO(achievementRepository.save(achievementMapper.toAchievement(achievementDTO)));
    }

    @Override
    public AchievementDTO update(Integer id, String name) {
        if(isExistByName(name)) throw new ControllerException(ControllerError.EXISTS);
        AchievementDTO achievement = achievementMapper.toAchievementDTO(achievementRepository.findById(id)
                .orElseThrow(() -> new ControllerException(ControllerError.NOT_FOUND)));
        achievement.setName(name);
        return achievementMapper.toAchievementDTO(achievementRepository.save(achievementMapper.toAchievement(achievement)));
    }


    private boolean isExistByName(String name) {
        return achievementRepository.findByName(name).isPresent();
    }
}
