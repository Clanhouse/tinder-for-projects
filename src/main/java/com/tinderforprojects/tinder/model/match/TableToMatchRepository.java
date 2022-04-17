package com.tinderforprojects.tinder.model.match;

import com.tinderforprojects.tinder.model.developer.Developer;
import com.tinderforprojects.tinder.model.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TableToMatchRepository extends JpaRepository<TableToMatch, Long> {

    Optional<TableToMatch> findByDeveloperIdAndProjectId(Long idDev, Long idProject);

    Optional<TableToMatch> findByDeveloperIdOrProjectId(Long idDev, Long idProject);


    @Query("SELECT p FROM TableToMatch t JOIN t.project p WHERE t.developer.id = :id AND t.isMatch = true")
    List<Project> getAllLikedProjectsByDevId(@Param("id") Long id);

    @Query("SELECT d FROM TableToMatch t JOIN t.developer d WHERE t.project.id = :id AND t.isMatch = true")
    List<Developer> getAllLikedDevsByProjectId(@Param("id") Long id);

    Optional<Boolean> findMatchByProjectId(Long projectId);
    
}
