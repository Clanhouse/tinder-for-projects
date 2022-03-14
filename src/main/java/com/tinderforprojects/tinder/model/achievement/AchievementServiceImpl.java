package com.tinderforprojects.tinder.model.achievement;

import com.tinderforprojects.tinder.exception.ErrorMessage;
import com.tinderforprojects.tinder.exception.notFound.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AchievementServiceImpl implements AchievementService {

    private final AchievementRepository achievementRepository;

    @Override
    public List<Achievement> findAll() {
        return achievementRepository.findAll();
    }

    @Override
    public Achievement findById(Long id) {
        return achievementRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND));
    }

    @Override
    public Achievement create(String name) {
        return achievementRepository.save(
                Achievement.builder()
                .name(name)
                .build());
    }

    @Override
    public Achievement update(Long id, String name) {
        return achievementRepository.findById(id)
                .map(achievementFromDb -> {
                    achievementFromDb.setName(name);
                    return achievementRepository.save(achievementFromDb);
                }).orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND));
    }
}
