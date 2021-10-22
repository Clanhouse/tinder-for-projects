package com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.ProjectDto;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Project;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ResourceNotFoundException;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.CompanyRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.ProjectRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;
    private CompanyRepository companyRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Project addProjectForCompany(Project project, Integer idCompany) {
        return companyRepository.findById(idCompany).map(company -> {
            project.setCompany(company);
            return projectRepository.save(project);
        }).orElseThrow(() -> new ResourceNotFoundException("idCompany " + idCompany + " not found"));
    }

    @Override
    public Optional<ProjectDto> getProjectById(Integer idProject) {
        return Optional.of(modelMapper.map(projectRepository.findById(idProject).get(), ProjectDto.class));
    }
}
