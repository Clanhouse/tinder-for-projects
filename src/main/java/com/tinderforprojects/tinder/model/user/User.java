package com.tinderforprojects.tinder.model.user;

import com.tinderforprojects.tinder.model.developer.Developer;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {

    @Id
    private String id;
    @OneToMany(mappedBy = "user")
    List<Developer> developers;
}
