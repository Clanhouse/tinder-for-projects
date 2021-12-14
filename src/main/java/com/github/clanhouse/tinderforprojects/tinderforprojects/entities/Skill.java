package com.github.clanhouse.tinderforprojects.tinderforprojects.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "skills")
@Data
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 3, message = "Name must have at least 3 characters")
    private String name;

    @ManyToMany(mappedBy = "skills")
    List<Developer> developers;

    @ManyToMany(mappedBy = "skills")
    List<Project> projects;

}
