package com.tinderforprojects.tinder.model.benefit.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class BenefitDto {

    private Long id;
    private String name;
}
