package com.tinderforprojects.tinder.model.developer;

import com.tinderforprojects.tinder.model.achievement.Achievement;
import com.tinderforprojects.tinder.model.photo.dto.PhotoDto;
import com.tinderforprojects.tinder.model.skill.Skill;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DeveloperService {

    Developer create(Developer developerDTO);

    Developer findById(Long id);

    Developer findRandom(Long projectId);

    List<Developer> findAll();

    Developer updatePersonalInformation(Long id, Developer developer);

    Developer updateAchievements(Long id, List<Achievement> achievements);

    Developer updateSkills(Long id, List<Skill> skills);

    List<PhotoDto> downloadPhotos(Long id);

    ResponseEntity<String> uploadPhoto(byte[] image, Long id);

    Developer findByUserId(String userId);

}
