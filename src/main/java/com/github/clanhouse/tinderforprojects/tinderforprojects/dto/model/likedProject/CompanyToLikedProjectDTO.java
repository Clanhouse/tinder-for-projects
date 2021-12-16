package com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.likedProject;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CompanyToLikedProjectDTO {

    private int id;
    @NotBlank
    @Size(min = 3, message = "Name must have at least 3 characters")
    private String name;

}
