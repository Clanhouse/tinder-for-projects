package com.github.clanhouse.tinderforprojects.tinderforprojects.repository;

import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Developer;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Project;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.TableToMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TableToMatchRepository extends JpaRepository<TableToMatch, Integer> {
    @Override
    boolean existsById(Integer idDev);

    Optional<TableToMatch> findByDeveloperIdAndProjectId(Integer idDev, Integer idProject);


    @Query("SELECT p FROM TableToMatch t JOIN t.project p WHERE t.developer.id = :id AND t.isMatch = true")
    List<Project> getAllLikedProjectsByDevId(Integer id);

    @Query("SELECT d FROM TableToMatch t JOIN t.developer d WHERE t.project.id = :id AND t.isMatch = true")
    List<Developer> getAllLikedDevsByProjectId(Integer id);


}
