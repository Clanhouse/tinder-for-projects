package com.tinderforprojects.tinder.model.achievement;

import com.tinderforprojects.tinder.model.BaseEntity;
import com.tinderforprojects.tinder.model.developer.Developer;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "achievements")
@Builder
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@AllArgsConstructor
public class Achievement extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, message = "Name must have at least 3 characters")
    private String name;
    @ManyToMany(mappedBy = "achievements")
    private List<Developer> developers;

    public Achievement() {

    }
}
