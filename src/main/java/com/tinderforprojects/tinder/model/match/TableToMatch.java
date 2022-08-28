package com.tinderforprojects.tinder.model.match;

import com.tinderforprojects.tinder.model.BaseEntity;
import com.tinderforprojects.tinder.model.developer.Developer;
import com.tinderforprojects.tinder.model.project.Project;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "table_to_matches")
@Builder
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@AllArgsConstructor
public class TableToMatch extends BaseEntity {

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

    public TableToMatch() {

    }

    @PrePersist
    public void prePersist(){
        isLike = true;
    }

}
