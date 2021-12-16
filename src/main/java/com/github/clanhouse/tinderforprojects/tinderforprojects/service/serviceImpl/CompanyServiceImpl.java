package com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper.CompanyMapper;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.company.CompanyDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ControllerError;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ControllerException;
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
        List<CompanyDTO> companies = companyMapper.toCompanyDTOs(companyRepository.findAll());
        if(companies.isEmpty()) throw new ControllerException(ControllerError.EMPTY);
        return companies;
    }

    @Override
    public CompanyDTO findById(Integer id) {
        return companyMapper.toCompanyDTO(companyRepository.findById(id)
                .orElseThrow(() -> new ControllerException(ControllerError.NOT_FOUND)));
    }

    @Override
    public CompanyDTO create(CompanyDTO companyDTO) {
        if(isExistByName(companyDTO.getName())) throw new ControllerException(ControllerError.EXISTS);
        return companyMapper.toCompanyDTO(companyRepository.save(companyMapper.toCompany(companyDTO)));
    }

    @Override
    public CompanyDTO update(Integer id, String name) {
        if(isExistByName(name)) throw new ControllerException(ControllerError.EXISTS);
        CompanyDTO company = companyMapper.toCompanyDTO(companyRepository.findById(id)
                .orElseThrow(() -> new ControllerException(ControllerError.NOT_FOUND)));
        company.setName(name);
        return companyMapper.toCompanyDTO(companyRepository.save(companyMapper.toCompany(company)));
    }


    private boolean isExistByName(String name) {
        return companyRepository.findByName(name).isPresent();
    }
}
