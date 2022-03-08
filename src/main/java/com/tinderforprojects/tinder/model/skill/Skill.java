package com.tinderforprojects.tinder.model.skill;

@Entity
@Table(name = "skills")
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, message = "Name must have at least 3 characters")
    private String name;

    @ManyToMany(mappedBy = "skills")
    List<Developer> developers;

    @ManyToMany(mappedBy = "skills")
    List<Project> projects;

}
