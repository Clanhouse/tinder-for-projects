package com.tinderforprojects.tinder.model.benefit;

import com.tinderforprojects.tinder.model.project.Project;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "benefits")
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Benefit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, message = "Name must have at least 3 characters")
    private String name;
    @ManyToMany(mappedBy = "benefits")
    private List<Project> projects;

    public Benefit() {

    }
}
