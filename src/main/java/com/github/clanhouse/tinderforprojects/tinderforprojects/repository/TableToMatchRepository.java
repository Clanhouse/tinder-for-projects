package com.github.clanhouse.tinderforprojects.tinderforprojects.repository;

import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.TableToMatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TableToMatchRepository extends JpaRepository<TableToMatch, Integer> {
    @Override
    boolean existsById(Integer idDev);

    Optional<TableToMatch> findByDeveloperIdAndProjectId(Integer idDev, Integer idProject);


}
