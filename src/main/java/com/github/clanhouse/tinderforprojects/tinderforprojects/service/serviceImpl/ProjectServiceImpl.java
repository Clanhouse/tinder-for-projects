package com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper.ProjectMapper;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.likedProject.DeveloperToLikedProjectDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.project.ProjectDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ResourceNotFoundException;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.CompanyRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.ProjectRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.TableToMatchRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final TableToMatchRepository tableToMatchRepository;
    private final CompanyRepository companyRepository;
    private final ProjectMapper projectMapper;

    @Override
    public ProjectDTO create(Integer companyId, ProjectDTO projectDTO) {
        projectDTO.setCompany(projectMapper.toCompanyDTO(companyRepository.getById(companyId)));
        projectDTO.setId(projectRepository.save(projectMapper.toProject(projectDTO)).getId());
        return projectDTO;
    }

    @Override
    public ProjectDTO findById(Integer id) {
        if(isExistById(id)){
            ProjectDTO projectDTO = projectMapper.toProjectDTO(projectRepository.getById(id));
            List<DeveloperToLikedProjectDTO> likedDevelopersDTOs = projectMapper.toDeveloperDTOs(tableToMatchRepository.getAllLikedDevsByProjectId(id));
            projectDTO.setLikedDevelopers(likedDevelopersDTOs);
            return projectDTO;
        }else{
            throw new ResourceNotFoundException("Developer not found");
        }
    }

    @Override
    public List<ProjectDTO> findAll() {
        List<ProjectDTO> projectDTOs = projectMapper.toProjectDTOs(projectRepository.findAll());
        for(ProjectDTO projectDTO : projectDTOs){
            projectDTO.setLikedDevelopers(projectMapper.toDeveloperDTOs(tableToMatchRepository.getAllLikedDevsByProjectId(projectDTO.getId())));
        }
        return projectDTOs;
    }

    @Override
    public boolean isExistById(Integer id) {
        return projectRepository.findById(id).isPresent();
    }


}
