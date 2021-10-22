package com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.DeveloperDto;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.ProjectDto;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Developer;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Project;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Skill;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ResourceNotFoundException;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.DeveloperRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.SkillRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.TableToMatchRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.DeveloperService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    private DeveloperRepository developerRepository;

    private SkillRepository skillRepository;

    private TableToMatchRepository tableToMatchRepository;

    private ModelMapper modelMapper;

    @Autowired
    public DeveloperServiceImpl(DeveloperRepository developerRepository, SkillRepository skillRepository, TableToMatchRepository tableToMatchRepository, ModelMapper modelMapper) {
        this.developerRepository = developerRepository;
        this.skillRepository = skillRepository;
        this.tableToMatchRepository =tableToMatchRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public Developer saveDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }

    @Override
    public Optional<DeveloperDto> findDeveloperById(Integer idDeveloper) {
        List<Project> projectList = tableToMatchRepository.getAllLikedProjectByDevId(idDeveloper);
        List<ProjectDto> projectDtoList = new ArrayList<>();
        for (Project project : projectList) {
            projectDtoList.add(modelMapper.map(project, ProjectDto.class));
        }
        Developer developer = developerRepository.findById(idDeveloper).get();
        DeveloperDto developerDto = modelMapper.map(developer, DeveloperDto.class);
        developerDto.setLikedProjects(projectDtoList);
        return Optional.of(developerDto);
    }

    public Skill addSkillForDev(Integer idDev, Skill skill){
        return developerRepository.findById(idDev).map(dev -> {
            skill.setDev(Collections.singletonList(dev));
            return skillRepository.save(skill);
        }).orElseThrow(() -> new ResourceNotFoundException("idCompany " + idDev + " not found"));
    }

    @Override
    public DeveloperDto findRandomDeveloper() {
        return modelMapper.map(developerRepository.getFirstRandomDeveloper(), DeveloperDto.class);
    }

}
