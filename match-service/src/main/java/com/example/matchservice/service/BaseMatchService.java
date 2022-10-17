package com.example.matchservice.service;

import com.example.matchservice.model.Like;
import com.example.matchservice.model.Match;
import com.example.matchservice.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class BaseMatchService implements MatchService {

    private final MatchRepository matchRepository;

    @Override
    public boolean isMatch(Long developerId, Long projectId) {
        return matchRepository.existsByDeveloperIdAndProjectIdAndMatchIs(developerId, projectId);
    }

    @Override
    public boolean like(Like like) {
        val developerId = like.developerId();
        val projectId = like.projectId();
        val matchOptional = matchRepository.findByDeveloperIdAndProjectId(developerId, projectId);

        return matchOptional
                .map(this::evaluateLikeWhenMatchExists)
                .orElseGet(() -> evaluateLikeWhenMatchDoesNotExists(developerId, projectId));

    }

    @Override
    public boolean unLike(Like like) {
        val developerId = like.developerId();
        val projectId = like.projectId();
        val matchOptional = matchRepository.findByDeveloperIdAndProjectId(developerId, projectId);

        return matchOptional
                .map(this::evaluateUnLikeWhenMatchExists)
                .orElseGet(() -> evaluateUnLikeWhenMatchDoesNotExists(developerId, projectId));
    }

    private boolean evaluateLikeWhenMatchExists(Match match) {
        if (match.isLike()) {
            match.setMatch(true);
            matchRepository.save(match);
            return true;
        }
        return false;
    }

    private boolean evaluateLikeWhenMatchDoesNotExists(Long developerId, Long projectId) {
        val match = Match.builder()
                .developerId(developerId)
                .projectId(projectId)
                .build();
        matchRepository.save(match);
        return false;
    }

    private boolean evaluateUnLikeWhenMatchExists(Match match) {
        match.setMatch(false);
        match.setLike(false);
        matchRepository.save(match);
        return false;
    }

    private boolean evaluateUnLikeWhenMatchDoesNotExists(Long developerId, Long projectId) {
        val match = Match.builder()
                .developerId(developerId)
                .projectId(projectId)
                .isMatch(false)
                .isLike(false)
                .build();
        matchRepository.save(match);
        return false;
    }

}
