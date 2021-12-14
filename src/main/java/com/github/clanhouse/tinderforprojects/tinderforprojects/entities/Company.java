package com.github.clanhouse.tinderforprojects.tinderforprojects.entities;

import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.model.StampedModel;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
@Data
public class Company extends StampedModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(min = 3, message = "Name must have at least 3 characters")
    private String name;

    @OneToMany(
            mappedBy = "company",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Project> projects = new ArrayList<>();


}
