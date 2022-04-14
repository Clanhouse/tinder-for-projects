package com.tinderforprojects.tinder.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseEntity {

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate created;


    @Column(name = "updated_date", nullable = false)
    @LastModifiedDate
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate updated;

}
