package com.tinderforprojects.tinder.model.photo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PhotoRepository extends JpaRepository<Photo, Long> {


    Optional<Photo> findByHash(String hash);
    List<Photo> findByDeveloperId(Long id);
    List<Photo> findByCompanyId(Long id);

}
