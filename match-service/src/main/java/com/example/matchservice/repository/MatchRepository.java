package com.example.matchservice.repository;

import com.example.matchservice.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatchRepository extends JpaRepository<Match, Long> {

    boolean existsByDeveloperIdAndProjectIdAndMatchIs(Long developerId, Long projectId);

    Optional<Match> findByDeveloperIdAndProjectId(Long developerId, Long projectId);
}
