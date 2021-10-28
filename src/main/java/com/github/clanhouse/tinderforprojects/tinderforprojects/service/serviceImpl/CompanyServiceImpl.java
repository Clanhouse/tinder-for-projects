package com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.CompanyDto;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.ProjectDto;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Company;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Project;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.CompanyRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.ProjectRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    private ProjectRepository projectRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<CompanyDto> findCompanyById(Integer idCompany) {
        Company company = companyRepository.findById(idCompany).get();
        CompanyDto companyDto = modelMapper.map(company, CompanyDto.class);
        companyDto.setProjects(getProjectDtoByCompanyId(idCompany));
        return Optional.of(companyDto);
    }

    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    private List<ProjectDto> getProjectDtoByCompanyId(Integer idCompany){
        List<Project> projectList = projectRepository.findAllByCompanyId(idCompany);
        List<ProjectDto> projectDtoList = new ArrayList<>();
        for (Project project : projectList) {
            projectDtoList.add(modelMapper.map(project, ProjectDto.class));
        }
        return projectDtoList;
    }
}
