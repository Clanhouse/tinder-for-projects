package com.github.clanhouse.tinderforprojects.tinderforprojects.entities;

import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.model.StampedModel;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "projects")
@Data
public class Project extends StampedModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 3, message = "Name must have at least 3 characters")
    private String name;

    private String description;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name="projects_skills",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name="projects_benefits",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "benefits_id")
    )
    private List<Benefit> benefits;

    @OneToMany(mappedBy = "project")
    private List<TableToMatch> tableToMatch;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;


}
