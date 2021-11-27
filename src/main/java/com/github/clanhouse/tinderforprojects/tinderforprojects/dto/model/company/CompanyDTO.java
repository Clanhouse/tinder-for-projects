package com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.company;

import lombok.Data;

import java.util.List;

@Data
public class CompanyDTO {

    private int id;
    private String name;
    private List<ProjectToCompanyDTO> projects;

}
