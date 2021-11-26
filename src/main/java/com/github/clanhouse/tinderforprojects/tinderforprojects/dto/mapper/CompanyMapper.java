package com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.company.CompanyDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Company;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

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
