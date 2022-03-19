package com.tinderforprojects.tinder.model.match.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class TableToMatchDto {

    private Long idDeveloper;
    private Long idProject;
}
