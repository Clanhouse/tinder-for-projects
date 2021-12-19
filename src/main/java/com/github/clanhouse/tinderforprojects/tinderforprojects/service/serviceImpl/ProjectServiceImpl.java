package com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper.CompanyMapper;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper.ProjectMapper;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.likedProject.DeveloperToLikedProjectDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.project.ProjectDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Company;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ControllerError;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ControllerException;
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
    private final CompanyRepository companyRepository;
    private final ProjectMapper projectMapper;
    private final TableToMatchRepository tableToMatchRepository;

    @Override
    public List<ProjectDTO> findAll() {
        List<ProjectDTO> projects = projectMapper.toProjectDTOs(projectRepository.findAll());
        for(ProjectDTO projectDTO : projects){
            projectDTO.setLikedDevelopers(projectMapper.toDeveloperDTOs(tableToMatchRepository.getAllLikedDevsByProjectId(projectDTO.getId())));
        }
        if (projects.isEmpty()) throw new ControllerException(ControllerError.EMPTY);
        return projects;
    }

    @Override
    public ProjectDTO findById(Integer id) {
        if (isExistById(id)) {
            ProjectDTO projectDTO = projectMapper.toProjectDTO(projectRepository.getById(id));
            List<DeveloperToLikedProjectDTO> likedDeveloperDTOs = projectMapper.toDeveloperDTOs(tableToMatchRepository.getAllLikedDevsByProjectId(id));
            projectDTO.setLikedDevelopers(likedDeveloperDTOs);
            return projectDTO;
        } else {
            throw new ControllerException(ControllerError.NOT_FOUND);
        }

    }

    @Override
    public ProjectDTO create(Integer companyId, ProjectDTO projectDTO) {
        if (!companyRepository.findById(companyId).isPresent())
            throw new ControllerException(ControllerError.NOT_FOUND);
        projectDTO.setCompany(projectMapper.toCompanyDTO(companyRepository.getById(companyId)));
        return projectMapper.toProjectDTO(projectRepository.save(projectMapper.toProject(projectDTO)));
    }

    private boolean isExistById(Integer id) {
        return projectRepository.findById(id).isPresent();
    }


}
