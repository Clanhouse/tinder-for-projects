package com.github.clanhouse.tinderforprojects.tinderforprojects.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public abstract class StampedModel implements Serializable {


    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDate created;


    @Column(name = "updated_date", nullable = false)
    @LastModifiedDate
    private LocalDate updated;

}

