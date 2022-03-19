package com.tinderforprojects.tinder.model.company.dto;

import com.tinderforprojects.tinder.model.company.Company;
import com.tinderforprojects.tinder.model.project.dto.ProjectMapper;
import lombok.AllArgsConstructor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyDTO toCompanyDTO(Company company);
    List<CompanyDTO> toCompanyDTOs(List<Company> companies);

    @InheritInverseConfiguration(name = "toCompanyDTO")
    Company toCompany(CompanyDTO companyDTO);

    @InheritInverseConfiguration(name = "toCompanyDTOs")
    List<Company> toCompanies(List<CompanyDTO> companyDTOs);

}
