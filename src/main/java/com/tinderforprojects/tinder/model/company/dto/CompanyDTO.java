package com.tinderforprojects.tinder.model.company.dto;


import com.tinderforprojects.tinder.model.photo.dto.PhotoDto;
import com.tinderforprojects.tinder.model.project.dto.ProjectToCompanyDto;
import lombok.*;

import java.util.List;

@Data
public class CompanyDTO {

    private Long id;
    private String name;
    private List<ProjectToCompanyDto> projects;
    private List<PhotoDto> photos;

}
