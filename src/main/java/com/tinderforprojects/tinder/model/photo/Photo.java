package com.tinderforprojects.tinder.model.photo;

import com.tinderforprojects.tinder.model.company.Company;
import com.tinderforprojects.tinder.model.developer.Developer;
import com.tinderforprojects.tinder.model.project.Project;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "photos")
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Photo {

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

    @ManyToOne
    private Project project;

    public Photo() {

    }
}
