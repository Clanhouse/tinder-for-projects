package com.github.clanhouse.tinderforprojects.tinderforprojects.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "benefits")
@Data
public class Benefit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "benefits")
    private List<Project> projects;

}
