package com.github.clanhouse.tinderforprojects.tinderforprojects.entities;


import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "skills")
@Data
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "skills")
    List<Developer> developers;

    @ManyToMany(mappedBy = "skills")
    List<Project> projects;

}
