package com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.company;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class CompanyDTO {

    private int id;
    @NotBlank
    @Size(min = 3, message = "Name must have at least 3 characters")
    private String name;
    private List<ProjectToCompanyDTO> projects;

}
