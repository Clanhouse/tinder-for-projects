package com.tinderforprojects.tinder.model.project;

import com.tinderforprojects.tinder.model.BaseEntity;
import com.tinderforprojects.tinder.model.benefit.Benefit;
import com.tinderforprojects.tinder.model.company.Company;
import com.tinderforprojects.tinder.model.match.TableToMatch;
import com.tinderforprojects.tinder.model.photo.Photo;
import com.tinderforprojects.tinder.model.skill.Skill;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "projects")
@Builder
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@AllArgsConstructor
public class Project extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, message = "Name must have at least 3 characters")
    private String name;

    @Column(columnDefinition = "TEXT")
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
    private List<TableToMatch> tableToMatches;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @OneToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "project_id")
    private List<Photo> photos;

    public Project() {

    }
}
