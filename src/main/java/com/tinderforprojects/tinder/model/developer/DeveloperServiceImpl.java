package com.tinderforprojects.tinder.model.developer;

import com.tinderforprojects.tinder.exception.ErrorMessage;
import com.tinderforprojects.tinder.exception.notFound.NotFoundException;
import com.tinderforprojects.tinder.model.achievement.Achievement;
import com.tinderforprojects.tinder.model.skill.Skill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeveloperServiceImpl implements DeveloperService{

    private final DeveloperRepository developerRepository;

    @Override
    public Developer create(Developer developer) {
        return developerRepository.save(developer);
    }

    @Override
    public Developer findById(Long id) {
        return developerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND));
    }

    @Override
    public Developer findRandom(Long projectId) {
        return null;
    }

    @Override
    public List<Developer> findAll() {
        return developerRepository.findAll();
    }

    @Override
    public Developer updatePersonalInformation(Long id, Developer developer) {
        return developerRepository.findById(id)
                .map(developerFromDb -> {
                    developerFromDb.setFirstName(developer.getFirstName());
                    developerFromDb.setLastName(developer.getLastName());
                    developerFromDb.setDescription(developer.getDescription());
                    developerFromDb.setProfession(developer.getProfession());
                    return developerRepository.save(developerFromDb);
                }).orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND));
    }

    @Override
    public Developer updateAchievements(Long id, List<Achievement> achievements) {
        return developerRepository.findById(id)
                .map(developerFromDb -> {
                    developerFromDb.setAchievements(achievements);
                    return developerRepository.save(developerFromDb);
                }).orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND));
    }

    @Override
    public Developer updateSkills(Long id, List<Skill> skills) {
        return  developerRepository.findById(id)
                .map(developerFromDb -> {
                    developerFromDb.setSkills(skills);
                    return developerRepository.save(developerFromDb);
                }).orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND));
    }

}
