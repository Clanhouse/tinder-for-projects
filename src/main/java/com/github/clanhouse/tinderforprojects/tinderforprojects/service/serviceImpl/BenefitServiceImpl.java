package com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper.BenefitMapper;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.benefit.BenefitDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ResourceNotFoundException;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.BenefitRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.BenefitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BenefitServiceImpl implements BenefitService {

    private final BenefitRepository benefitRepository;
    private final BenefitMapper benefitMapper;

    @Override
    public List<BenefitDTO> findAll() {
        return benefitMapper.toBenefitsDTOs(benefitRepository.findAll());
    }

    @Override
    public BenefitDTO findById(Integer id) {
        if(isExistById(id)){
            return benefitMapper.toBenefitsDTO(benefitRepository.getById(id));
        }else {
            throw new ResourceNotFoundException("Benefit not found");
        }
    }

    @Override
    public BenefitDTO create(BenefitDTO benefitDTO) {
        benefitDTO.setId(benefitRepository.save(benefitMapper.toBenefit(benefitDTO)).getId());
        return benefitDTO;
    }

    @Override
    public boolean isExistById(Integer id) {
        return benefitRepository.findById(id).isPresent();
    }
}
