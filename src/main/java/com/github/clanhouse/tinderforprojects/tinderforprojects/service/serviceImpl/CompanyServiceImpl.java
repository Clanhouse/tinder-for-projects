package com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper.CompanyMapper;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.company.CompanyDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ResourceNotFoundException;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.CompanyRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public List<CompanyDTO> findAll() {
        return companyMapper.toCompanyDTOs(companyRepository.findAll());
    }

    @Override
    public CompanyDTO findById(Integer id) {
        if(isExistById(id)){
            return companyMapper.toCompanyDTO(companyRepository.getById(id));
        }else{
            throw new ResourceNotFoundException("Company not found");
        }
    }

    @Override
    public CompanyDTO create(CompanyDTO companyDTO) {
        companyDTO.setId(companyRepository.save(companyMapper.toCompany(companyDTO)).getId());
        return companyDTO;
    }


    public boolean isExistById(Integer id){
        return companyRepository.findById(id).isPresent();
    }
}
