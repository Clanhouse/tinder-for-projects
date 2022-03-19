package com.tinderforprojects.tinder.model.benefit.dto;

import com.tinderforprojects.tinder.model.benefit.Benefit;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BenefitMapper {

    BenefitDTO toBenefitsDTO(Benefit benefit);
    List<BenefitDTO> toBenefitsDTOs(List<Benefit> benefits);
    @InheritInverseConfiguration(name = "toBenefitsDTOs")
    List<Benefit> toBenefits(List<BenefitDTO> benefitDTOS);
    Benefit toBenefit(BenefitDTO benefitDTO);

}
