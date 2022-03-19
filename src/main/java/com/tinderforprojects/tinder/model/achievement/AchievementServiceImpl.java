package com.tinderforprojects.tinder.model.achievement;

import com.tinderforprojects.tinder.exception.ErrorMessage;
import com.tinderforprojects.tinder.exception.badRequest.BadRequestException;
import com.tinderforprojects.tinder.exception.notFound.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AchievementServiceImpl implements AchievementService {

    private final AchievementRepository achievementRepository;

    @Override
    public List<Achievement> findAll() {
        log.info("Downloading all achievements");
        return achievementRepository.findAll();
    }

    @Override
    public Achievement findById(Long id) {
        log.info(String.format("Downloading achievement by id %d", id));
        return achievementRepository.findById(id)
                .orElseThrow(() -> {
                    log.error(String.format("Achievement id: %d does not exists", id));
                    return new NotFoundException(ErrorMessage.NOT_FOUND);
                });

    }

    @Override
    public Achievement create(String name) {
        log.info(String.format("Creating new achievement: %s", name));
        validateName(name);
        return achievementRepository.save(
                Achievement.builder()
                        .name(name)
                        .build());
    }

    @Override
    public Achievement update(Long id, String name) {
        log.info(String.format("Updating achievement: %s , id: %d", name, id));
        validateName(name);
        return achievementRepository.findById(id)
                .map(achievementFromDb -> {
                    achievementFromDb.setName(name);
                    log.info(String.format("Achievement %s updated, new name: %s", achievementFromDb.getName(), name));
                    return achievementRepository.save(achievementFromDb);
                }).orElseThrow(() -> {
                    log.error(String.format("Achievement id: %d does not exists", id));
                    return new NotFoundException(ErrorMessage.NOT_FOUND);
                });
    }

    private void validateName(String name) {
        if (name.length() < 3) {
            log.error(String.format("Invalid achievement name %s", name));
            throw new BadRequestException(ErrorMessage.BAD_REQUEST);
        }
    }
}
