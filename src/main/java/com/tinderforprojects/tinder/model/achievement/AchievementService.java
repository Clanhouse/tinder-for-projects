package com.tinderforprojects.tinder.model.achievement;

import java.util.List;

public interface AchievementService {

    List<Achievement> findAll();

    Achievement findById(Long id);

    Achievement create(String name);

    Achievement update(Long id, String name);
}
