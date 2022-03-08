package com.tinderforprojects.tinder.model.skill.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class SkillDto {

    private Long id;
    private String name;

}
