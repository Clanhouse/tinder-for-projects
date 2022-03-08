package com.tinderforprojects.tinder.model.achievement;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "achievements")
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, message = "Name must have at least 3 characters")
    private String name;
    @ManyToMany(mappedBy = "achievements")
    private List<Developer> developers;
}
