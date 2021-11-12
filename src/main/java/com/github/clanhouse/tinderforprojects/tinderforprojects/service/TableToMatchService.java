package com.github.clanhouse.tinderforprojects.tinderforprojects.service;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.match.ProjectDevDto;

public interface TableToMatchService {

    boolean match(ProjectDevDto projectDevDto);
}
