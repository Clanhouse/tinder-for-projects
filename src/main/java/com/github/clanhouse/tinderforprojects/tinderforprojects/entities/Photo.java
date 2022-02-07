package com.github.clanhouse.tinderforprojects.tinderforprojects.entities;

import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.model.StampedModel;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "photos")
@Data
public class Photo extends StampedModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hash;

    @Lob
    @Column(name = "image_bytes")
    @Type(type = "org.hibernate.type.ImageType")
    private byte[] photo;

    @ManyToOne
    private Developer developer;

    @ManyToOne
    private Company company;

}
