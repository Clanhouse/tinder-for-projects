package com.tinderforprojects.tinder.model.project;

import com.tinderforprojects.tinder.exception.ErrorMessage;
import com.tinderforprojects.tinder.exception.notFound.NotFoundException;
import com.tinderforprojects.tinder.model.benefit.Benefit;
import com.tinderforprojects.tinder.model.skill.Skill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

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
        return projectRepository.getRandomProjects(developerId);
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
}
