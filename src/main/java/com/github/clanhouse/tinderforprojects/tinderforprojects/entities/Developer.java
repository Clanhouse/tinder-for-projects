package com.github.clanhouse.tinderforprojects.tinderforprojects.entities;

import javax.persistence.*;

@Entity
@Table(name = "Developers")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String developersFirstName;
    private String developersLastName;
    private String dvelopersProgrammingLenguage;

}
