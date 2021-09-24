package com.github.clanhouse.tinderforprojects.tinderforprojects.repository;

import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {



}
