package com.tinderforprojects.tinder.model.company;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "companies")
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Company {

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
    private List<Project> projects = new ArrayList<>();

    @OneToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "company_id")
    private List<Photo> photos;
}
