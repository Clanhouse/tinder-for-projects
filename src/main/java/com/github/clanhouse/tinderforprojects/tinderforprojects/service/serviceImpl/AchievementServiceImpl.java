package com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper.AchievementMapper;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.achievement.AchievementDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ResourceNotFoundException;
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
        return achievementMapper.toAchievementDTOs(achievementRepository.findAll());
    }

    @Override
    public AchievementDTO findById(Integer id) {
        if(isExistById(id)){
            return achievementMapper.toAchievementDTO(achievementRepository.getById(id));
        }else {
            throw new ResourceNotFoundException("Achievement not found");
        }
    }

    @Override
    public AchievementDTO create(AchievementDTO achievementDTO) {
        achievementDTO.setId(achievementRepository.save(achievementMapper.toAchievement(achievementDTO)).getId());
        return achievementDTO;
    }

    @Override
    public boolean isExistById(Integer id) {
        return achievementRepository.findById(id).isPresent();
    }
}
