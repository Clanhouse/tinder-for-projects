package com.tinderforprojects.tinder.model.project;

import com.tinderforprojects.tinder.model.benefit.Benefit;
import com.tinderforprojects.tinder.model.photo.dto.PhotoDto;
import com.tinderforprojects.tinder.model.skill.Skill;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectService {

    Project create(Project project);

    Project findById(Long id);

    Project findRandom(Long developerId);

    List<Project> findAll();

    Project updateBasicInformation(Long id, Project project);

    Project updateSkills(Long id, List<Skill> skills);

    Project updateBenefits(Long id, List<Benefit> benefits);

    ResponseEntity<String> uploadPhoto(byte[] image, Long id);

    List<PhotoDto> downloadPhotos(Long id);
}
