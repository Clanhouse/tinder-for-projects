package com.github.clanhouse.tinderforprojects.tinderforprojects.repository;

import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Integer> {
}