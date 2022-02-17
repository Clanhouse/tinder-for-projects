package com.github.clanhouse.tinderforprojects.tinderforprojects.repository;

import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Developer;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query(nativeQuery=true, value="select * from projects\n" +
            "    left join table_to_matches ttm on projects.id = ttm.project_id\n" +
            "where ttm.project_id is null\n" +
            "   or ttm.developer_id <> :developerId")
    List<Project> getRandomProjects(Integer developerId);


}
