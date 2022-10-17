package com.example.matchservice.service;

import com.example.matchservice.model.Like;
import com.example.matchservice.model.Match;

import java.util.Optional;

public interface MatchService {

    boolean isMatch(Long developerId, Long companyId);

    boolean like(Like like);

    boolean unLike(Like like);
}
