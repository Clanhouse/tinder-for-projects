package com.tinderforprojects.tinder.model.developer;

import com.tinderforprojects.tinder.exception.ErrorMessage;
import com.tinderforprojects.tinder.exception.notFound.NotFoundException;
import com.tinderforprojects.tinder.model.achievement.Achievement;
import com.tinderforprojects.tinder.model.photo.PhotoService;
import com.tinderforprojects.tinder.model.photo.dto.PhotoDto;
import com.tinderforprojects.tinder.model.skill.Skill;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeveloperServiceImpl implements DeveloperService{

    private final DeveloperRepository developerRepository;
    private final PhotoService photoService;


    @Override
    public Developer create(Developer developer) {
        log.info("Creating developer");
        return developerRepository.save(developer);
    }

    @Override
    public Developer findById(Long id) {
        log.info(String.format("Downloading developer by id: %d", id));
        return developerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND));
    }

    @Override
    public Developer findRandom(Long projectId) {
        log.info(String.format("Downloading random developer by projectId: %d", projectId));
        List<Developer> developers = developerRepository.getRandomDevelopers(projectId);
        if(developers.isEmpty()) {
            throw new NotFoundException(ErrorMessage.NOT_FOUND);
        } else {
            return developers.get(getRandomId(developers.size() - 1));
        }
    }

    @Override
    public List<Developer> findAll() {
        log.info("Downloading all developers");
        return developerRepository.findAll();
    }

    @Override
    public Developer updatePersonalInformation(Long id, Developer developer) {
        log.info(String.format("Updating developer by id: %d", id));
        return developerRepository.findById(id)
                .map(developerFromDb -> {
                    developerFromDb.setFirstName(developer.getFirstName());
                    developerFromDb.setLastName(developer.getLastName());
                    developerFromDb.setDescription(developer.getDescription());
                    developerFromDb.setProfession(developer.getProfession());
                    log.info("Developer updated");
                    return developerRepository.save(developerFromDb);
                }).orElseThrow(() -> {
                    log.error(String.format("Developer id: %d does not exists", id));
                    return new NotFoundException(ErrorMessage.NOT_FOUND);
                });
    }

    @Override
    public Developer updateAchievements(Long id, List<Achievement> achievements) {
        return developerRepository.findById(id)
                .map(developerFromDb -> {
                    developerFromDb.setAchievements(achievements);
                    return developerRepository.save(developerFromDb);
                }).orElseThrow(() -> {
                    log.error(String.format("Developer id: %d does not exists", id));
                    return new NotFoundException(ErrorMessage.NOT_FOUND);
                });
    }

    @Override
    public Developer updateSkills(Long id, List<Skill> skills) {
        return  developerRepository.findById(id)
                .map(developerFromDb -> {
                    developerFromDb.setSkills(skills);
                    return developerRepository.save(developerFromDb);
                }).orElseThrow(() -> {
                    log.error(String.format("Developer id: %d does not exists", id));
                    return new NotFoundException(ErrorMessage.NOT_FOUND);
                });
    }

    @Override
    public List<PhotoDto> downloadPhotos(Long id) {
        return photoService.getPhotosUrlsByIdAndType(id, "developer");
    }

    @Override
    public ResponseEntity<String> uploadPhoto(byte[] image, Long id) {
        if (photoService.upload(image, id, "developer")) {
            return ResponseEntity.ok()
                    .body("Photo created");
        } else {
            return ResponseEntity.badRequest().body("Error while creating photo - check logs");
        }
    }

    private int getRandomId(int max) {
        return new Random().nextInt(max);
    }

}
