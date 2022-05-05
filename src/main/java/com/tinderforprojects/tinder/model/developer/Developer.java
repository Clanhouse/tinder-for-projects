package com.tinderforprojects.tinder.model.developer;

import com.tinderforprojects.tinder.model.BaseEntity;
import com.tinderforprojects.tinder.model.achievement.Achievement;
import com.tinderforprojects.tinder.model.match.TableToMatch;
import com.tinderforprojects.tinder.model.photo.Photo;
import com.tinderforprojects.tinder.model.skill.Skill;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "developers")
@Builder
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@AllArgsConstructor
public class Developer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, message = "Name must have at least 3 characters")
    @Column(name = "first_name")
    private String firstName;
    @NotBlank
    @Size(min = 3, message = "Lastname must have at least 3 characters")
    @Column(name = "last_name")
    private String lastName;

    private String description;

    private String profession;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "developers_achievements",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "achievement_id")
    )
    private List<Achievement> achievements;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "developers_skills",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;

    @OneToMany(mappedBy = "developer")
    private List<TableToMatch> tableToMatches;

    @OneToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "developer_id")
    private List<Photo> photos;

    public Developer() {

    }
}
