package com.tinderforprojects.tinder.model.match;

import com.tinderforprojects.tinder.model.developer.Developer;
import com.tinderforprojects.tinder.model.match.dto.TableToMatchDto;
import com.tinderforprojects.tinder.model.project.Project;

import java.util.List;

public interface TableToMatchService {

    boolean like(TableToMatchDto tableToMatchDto);

    boolean unLike(TableToMatchDto tableToMatchDto);

    List<Developer> findAllLikedDevelopersByProjectId(Long id);

    List<Project> findAllLikedProjectsByDeveloperId(Long id);
}
