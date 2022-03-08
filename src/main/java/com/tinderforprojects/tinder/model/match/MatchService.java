package com.tinderforprojects.tinder.model.match;

import com.tinderforprojects.tinder.model.match.dto.MatchDto;

public interface MatchService {

    boolean like(MatchDto matchDto);

    boolean unLike(MatchDto matchDto);
}
