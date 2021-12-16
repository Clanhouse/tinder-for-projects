package com.github.clanhouse.tinderforprojects.tinderforprojects.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table (name = "benefits")
@Data
public class Benefit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(min = 3, message = "Name must have at least 3 characters")
    private String name;

    @ManyToMany(mappedBy = "benefits")
    private List<Project> projects;

}
