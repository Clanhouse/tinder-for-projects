package com.tinderforprojects.tinder.model.company.dto;

import com.tinderforprojects.tinder.model.company.Company;
import com.tinderforprojects.tinder.model.project.dto.ProjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class CompanyMapper {

    private final ProjectMapper projectMapper;

    public Company toCompany(CompanyDto companyDto) {
        return Company.builder()
                .id(companyDto.getId())
                .name(companyDto.getName())
                .build();
    }

    public CompanyDto toCompanyDto(Company company) {
        return CompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .projectsDto(projectMapper.toProjectsToCompanyDto(company.getProjects()))
                .photosDto(new ArrayList<>())
                .build();
    }


    public List<Company> toCompanies(List<CompanyDto> companiesDto) {
        List<Company> companies = new ArrayList<>();
        for(CompanyDto companyDto : companiesDto){
            companies.add(toCompany(companyDto));
        }
        return companies;
    }

    public List<CompanyDto> toCompaniesDto(List<Company> companies) {
        List<CompanyDto> companiesDto = new ArrayList<>();
        for (Company company : companies) {
            companiesDto.add(toCompanyDto(company));
        }
        return companiesDto;
    }

}
