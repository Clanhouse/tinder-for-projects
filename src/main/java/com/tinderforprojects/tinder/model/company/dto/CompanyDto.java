package com.tinderforprojects.tinder.model.company.dto;


import com.tinderforprojects.tinder.model.photo.dto.PhotoDto;
import com.tinderforprojects.tinder.model.project.dto.ProjectDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@Setter
@ToString
public class CompanyDto {

    private Long id;
    private String name;
    private List<ProjectDto> projectsDto;
    private List<PhotoDto> photosDto;

}