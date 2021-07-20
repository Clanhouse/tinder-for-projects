package com.github.clanhouse.tinderforprojects.tinderforprojects.service;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.ProjectDevDto;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Developer;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Project;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.TableToMatch;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.DeveloperRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.ProjectRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.TableToMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TableToMatchService {

    private TableToMatchRepository tableToMatchRepository;

    private DeveloperRepository developerRepository;

     private ProjectRepository projectRepository;

     @Autowired
    public TableToMatchService(TableToMatchRepository tableToMatchRepository, DeveloperRepository developerRepository, ProjectRepository projectRepository) {
        this.tableToMatchRepository = tableToMatchRepository;
        this.developerRepository = developerRepository;
        this.projectRepository = projectRepository;
    }

    public void match(ProjectDevDto projectDevDto) {

        Integer devId = projectDevDto.getIdDev();

        Integer prjId = projectDevDto.getIdProject();

        Optional<TableToMatch> tableToMatchOptional =
                tableToMatchRepository.findByDeveloperIdAndProjectId(devId, prjId);

        if (tableToMatchOptional.isPresent()) {
            TableToMatch tableToMatch = tableToMatchOptional.get();
            tableToMatch.setMatch(true);
            tableToMatchRepository.save(tableToMatch);

        } else {

            TableToMatch tableToMatch = new TableToMatch();
            Developer getDevById = developerRepository.getById(devId);
            Project getProjectById = projectRepository.getById(prjId);
            tableToMatch.setDeveloper(getDevById);
            tableToMatch.setProject(getProjectById);
            tableToMatchRepository.save(tableToMatch);
        }
    }
}

