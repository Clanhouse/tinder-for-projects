package com.tinderforprojects.tinder.model.benefit.dto;

import com.tinderforprojects.tinder.model.benefit.Benefit;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BenefitMapper {

    Benefit toBenefit(BenefitDto benefitDto) {
        return Benefit.builder()
                .id(benefitDto.getId())
                .name(benefitDto.getName())
                .build();
    }

    BenefitDto toBenefitDto(Benefit benefit) {
        return BenefitDto.builder()
                .id(benefit.getId())
                .name(benefit.getName())
                .build();
    }

    List<Benefit> toBenefits(List<BenefitDto> benefitsDto) {
        List<Benefit> benefits = new ArrayList<>();
        for (BenefitDto benefitDto : benefitsDto) {
            benefits.add(toBenefit(benefitDto));
        }
        return benefits;
    }

    List<BenefitDto> toBenefitsDto(List<Benefit> benefits) {
        List<BenefitDto> benefitsDto = new ArrayList<>();
        for (Benefit benefit : benefits) {
            benefitsDto.add(toBenefitDto(benefit));
        }
        return benefitsDto;
    }

}
