package com.tinderforprojects.tinder.model.project.dto;

import com.tinderforprojects.tinder.model.benefit.dto.BenefitDTO;
import com.tinderforprojects.tinder.model.company.dto.CompanyDTO;
import com.tinderforprojects.tinder.model.company.dto.CompanyToProjectDTO;
import com.tinderforprojects.tinder.model.photo.dto.PhotoDto;
import com.tinderforprojects.tinder.model.skill.dto.SkillDTO;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class ProjectDTO {

    private Long id;
    @NotBlank
    @Size(min = 3, message = "Name must have at least 3 characters")
    private String name;
    private String description;
    private List<SkillDTO> skills;
    private List<BenefitDTO> benefits;
    private CompanyToProjectDTO company;
    private List<PhotoDto> photos;

}
