package com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.DeveloperDto;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.ProjectDto;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Developer;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Project;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ResourceNotFoundException;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.CompanyRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.ProjectRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.TableToMatchRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.DeveloperService;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;
    private CompanyRepository companyRepository;
    private TableToMatchRepository tableToMatchRepository;
    private ModelMapper modelMapper;


    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, CompanyRepository companyRepository, TableToMatchRepository tableToMatchRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.companyRepository = companyRepository;
        this.tableToMatchRepository = tableToMatchRepository;
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
        Project project = projectRepository.findById(idProject).get();
        ProjectDto projectDto = modelMapper.map(project, ProjectDto.class);
        projectDto.setLikedDevs(getLikedDevsByProjectId(idProject));
        return Optional.of(projectDto);
    }

    private List<DeveloperDto> getLikedDevsByProjectId(Integer idProject){
        List<Developer> developerList = tableToMatchRepository.getAllLikedDevsByProjectId(idProject);
        List<DeveloperDto> developerDtoList = new ArrayList<>();
        for(Developer developer : developerList){
            developerDtoList.add(modelMapper.map(developer, DeveloperDto.class));
        }
        return developerDtoList;
    }



}
