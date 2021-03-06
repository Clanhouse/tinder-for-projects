package com.tinderforprojects.tinder.model.company;

import com.tinderforprojects.tinder.model.BaseEntity;
import com.tinderforprojects.tinder.model.photo.Photo;
import com.tinderforprojects.tinder.model.project.Project;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "companies")
@Builder
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@AllArgsConstructor
public class Company extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, message = "Name must have at least 3 characters")
    private String name;
    @OneToMany(
            mappedBy = "company",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Project> projects;

    @OneToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "company_id")
    private List<Photo> photos;

    public Company() {

    }
}
