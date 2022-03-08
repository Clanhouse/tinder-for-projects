package com.tinderforprojects.tinder.model.match;

import com.tinderforprojects.tinder.model.developer.Developer;
import com.tinderforprojects.tinder.model.project.Project;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "companies")
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Developer developer;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Project project;

    @Column(name = "is_match")
    boolean isMatch;

    @Column(name = "is_like")
    boolean isLike;

    public Match() {

    }

    @PrePersist
    public void prePersist(){
        isLike = true;
    }

}
