package com.github.clanhouse.tinderforprojects.tinderforprojects.entities;

import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.model.StampedModel;

import javax.persistence.*;

@Entity
@Table(name = "photos")
public class Photo extends StampedModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "image_bytes", columnDefinition = "BLOB")
    private byte[] photo;

}
