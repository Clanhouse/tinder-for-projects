package com.tinderforprojects.tinder.model.company.dto;


import com.tinderforprojects.tinder.model.photo.dto.PhotoDto;
import com.tinderforprojects.tinder.model.project.dto.ProjectToCompanyDto;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class CompanyDTO {

    private Long id;
    @NotBlank
    @Size(min = 3, message = "Name must have at least 3 characters")
    private String name;
    private List<ProjectToCompanyDto> projects;
    private List<PhotoDto> photos;

}
