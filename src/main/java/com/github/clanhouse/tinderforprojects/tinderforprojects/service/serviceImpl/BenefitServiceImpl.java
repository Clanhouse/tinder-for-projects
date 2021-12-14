package com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper.BenefitMapper;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.benefit.BenefitDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ControllerError;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ControllerException;
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
        List<BenefitDTO> benefits = benefitMapper.toBenefitsDTOs(benefitRepository.findAll());
        if(benefits.isEmpty()) throw new ControllerException(ControllerError.EMPTY);
        return benefits;
    }

    @Override
    public BenefitDTO findById(Integer id) {
        return benefitMapper.toBenefitsDTO(benefitRepository.findById(id)
                .orElseThrow(() -> new ControllerException(ControllerError.NOT_FOUND)));
    }

    @Override
    public BenefitDTO create(BenefitDTO benefitDTO) {
        if(isExistByName(benefitDTO.getName())) throw new ControllerException(ControllerError.EXISTS);
        return benefitMapper.toBenefitsDTO(benefitRepository.save(benefitMapper.toBenefit(benefitDTO)));
    }

    @Override
    public BenefitDTO update(Integer id, String name) {
        if(isExistByName(name)) throw new ControllerException(ControllerError.EXISTS);
        BenefitDTO benefit = benefitMapper.toBenefitsDTO(benefitRepository.findById(id)
                .orElseThrow(() -> new ControllerException(ControllerError.NOT_FOUND)));
        benefit.setName(name);
        return benefitMapper.toBenefitsDTO(benefitRepository.save(benefitMapper.toBenefit(benefit)));
    }


    private boolean isExistByName(String name) {
        return benefitRepository.findByName(name).isPresent();
    }
}
