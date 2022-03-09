package com.tinderforprojects.tinder.model.benefit.dto;

import com.tinderforprojects.tinder.model.benefit.Benefit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BenefitMapperTest {

    @Autowired
    private BenefitMapper benefitMapper;

    @Test
    void shouldReturnMappedBenefitToBenefitDto() {
        //given
        Benefit benefit = Benefit.builder()
                .id(1L)
                .name("Pieniądze")
                .build();
        //when
        BenefitDto benefitDto = benefitMapper.toBenefitDto(benefit);
        //then
        assertNotNull(benefitDto);
        assertEquals(benefitDto.getId(), 1L);
        assertEquals(benefitDto.getName(), "Pieniądze");
        assertInstanceOf(BenefitDto.class, benefitDto);
    }

    @Test
    void shouldReturnMappedBenefitDtoToBenefit() {
        //given
        BenefitDto benefitDto = BenefitDto.builder()
                .id(1L)
                .name("Pieniądze")
                .build();
        //when
        Benefit benefit = benefitMapper.toBenefit(benefitDto);
        //then
        assertNotNull(benefit);
        assertEquals(benefit.getId(), 1L);
        assertEquals(benefit.getName(), "Pieniądze");
        assertInstanceOf(Benefit.class, benefit);

    }

    @Test
    void shouldReturnMappedListOfBenefitsToListOfBenefitsDto() {
        //given
        List<Benefit> benefits = Arrays.asList(
                Benefit.builder()
                        .id(1L)
                        .name("Pieniądze")
                        .build(),
                Benefit.builder()
                        .id(2L)
                        .name("Certyfikat")
                        .build());
        //when
        List<BenefitDto> benefitsDto = benefitMapper.toBenefitsDto(benefits);
        //then
        assertEquals(2, benefits.size());
        assertEquals(1L, benefits.get(0).getId());
        assertEquals("Certyfikat", benefits.get(1).getName());
        assertInstanceOf(Benefit.class, benefits.get(0));

    }

    @Test
    void shouldReturnMappedListOfBenefitsDtoToListOfBenefits() {
        //given
        List<BenefitDto> benefitsDto = Arrays.asList(
                BenefitDto.builder()
                        .id(1L)
                        .name("Pieniądze")
                        .build(),
                BenefitDto.builder()
                        .id(2L)
                        .name("Certyfikat")
                        .build());
        //when
        List<Benefit> benefits = benefitMapper.toBenefits(benefitsDto);
        //then
        assertEquals(2, benefitsDto.size());
        assertEquals(1L, benefitsDto.get(0).getId());
        assertEquals("Certyfikat", benefitsDto.get(1).getName());
        assertInstanceOf(BenefitDto.class, benefitsDto.get(0));

    }

}