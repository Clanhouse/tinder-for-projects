package com.tinderforprojects.tinder.model.achievement.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class AchievementDto {

    private Long id;
    private String name;

}
