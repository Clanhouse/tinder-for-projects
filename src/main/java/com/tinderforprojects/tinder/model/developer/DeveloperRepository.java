package com.tinderforprojects.tinder.model.developer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    @Query(nativeQuery=true, value="select * from developers\n" +
            "    left join table_to_matches ttm on developers.id = ttm.developer_id\n" +
            "where ttm.developer_id is null\n" +
            "   or ttm.project_id <> :projectId")
    List<Developer> getRandomDevelopers(Long projectId);

    Optional<Developer> findByUserId(String userId);

}
