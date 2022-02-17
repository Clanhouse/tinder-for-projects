package com.github.clanhouse.tinderforprojects.tinderforprojects.repository;

import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Integer> {

    @Query(nativeQuery=true, value="select * from developers\n" +
            "    left join table_to_matches ttm on developers.id = ttm.developer_id\n" +
            "where ttm.developer_id is null\n" +
            "   or ttm.project_id <> :projectId")
    List<Developer> getFirstRandomDeveloper(Integer projectId);
}
