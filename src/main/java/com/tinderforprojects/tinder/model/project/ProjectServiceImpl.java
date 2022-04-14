package com.tinderforprojects.tinder.model.project;

import com.tinderforprojects.tinder.exception.ErrorMessage;
import com.tinderforprojects.tinder.exception.notFound.NotFoundException;
import com.tinderforprojects.tinder.model.benefit.Benefit;
import com.tinderforprojects.tinder.model.photo.PhotoService;
import com.tinderforprojects.tinder.model.photo.dto.PhotoDto;
import com.tinderforprojects.tinder.model.skill.Skill;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final PhotoService photoService;

    @Override
    public Project create(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND));
    }

    @Override
    public Project findRandom(Long developerId) {
        log.info(String.format("Downloading random project by devId: %d", developerId));
        List<Project> projects = projectRepository.getRandomProjects(developerId);
        if (projects.isEmpty()) {
            throw new NotFoundException(ErrorMessage.NOT_FOUND);
        } else {
            return projects.get(0);
        }
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project updateBasicInformation(Long id, Project project) {
        return projectRepository.findById(id)
                .map(projectFromDb -> {
                    projectFromDb.setName(project.getName());
                    projectFromDb.setDescription(project.getDescription());
                    return projectRepository.save(projectFromDb);
                }).orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND));
    }

    @Override
    public Project updateSkills(Long id, List<Skill> skills) {
        return projectRepository.findById(id)
                .map(projectFromDb -> {
                    projectFromDb.setSkills(skills);
                    return projectRepository.save(projectFromDb);
                }).orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND));
    }

    @Override
    public Project updateBenefits(Long id, List<Benefit> benefits) {
        return projectRepository.findById(id)
                .map(projectFromDb -> {
                    projectFromDb.setBenefits(benefits);
                    return projectRepository.save(projectFromDb);
                }).orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND));
    }

    @Override
    public ResponseEntity<String> uploadPhoto(byte[] image, Long id) {
        if (photoService.upload(image, id, "project")) {
            return ResponseEntity.ok()
                    .body("Photo created");
        } else {
            return ResponseEntity.badRequest().body("Error while creating photo - check logs");
        }
    }

    @Override
    public List<PhotoDto> downloadPhotos(Long id) {
        return photoService.getPhotosUrlsByIdAndType(id, "project");
    }
}
