package com.tinderforprojects.tinder.model.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query(nativeQuery=true, value="select * from projects\n" +
            "    left join table_to_matches ttm on projects.id = ttm.project_id\n" +
            "where ttm.project_id is null\n" +
            "   or ttm.developer_id <> :developerId")
    List<Project> getRandomProjects(Long developerId);

}
