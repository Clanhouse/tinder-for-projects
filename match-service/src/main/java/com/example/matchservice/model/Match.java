package com.example.matchservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Match {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Column(nullable = false)
    private Long developerId;
    @NotNull
    @Column(nullable = false)
    private Long projectId;
    @NotNull
    @Column(nullable = false)
    boolean isMatch;
    @NotNull
    @Column(nullable = false)
    boolean isLike;

    @PrePersist
    public void prePersist() {
        isLike = true;
    }

}
