package com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.match.ProjectDevDto;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Developer;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Project;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.TableToMatch;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.DeveloperRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.ProjectRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.TableToMatchRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.TableToMatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TableToMatchServiceImpl implements TableToMatchService {

    private final TableToMatchRepository tableToMatchRepository;
    private final DeveloperRepository developerRepository;
    private final ProjectRepository projectRepository;



    public boolean match(ProjectDevDto projectDevDto) {
        Integer devId = projectDevDto.getIdDev();
        Integer prjId = projectDevDto.getIdProject();
        Optional<TableToMatch> tableToMatchOptional =
                tableToMatchRepository.findByDeveloperIdAndProjectId(devId, prjId);

        if (tableToMatchOptional.isPresent()) {
            TableToMatch tableToMatch = tableToMatchOptional.get();
            tableToMatch.setMatch(true);
            tableToMatchRepository.save(tableToMatch);
            return true;

        } else {
            TableToMatch tableToMatch = new TableToMatch();
            Developer getDevById = developerRepository.getById(devId);
            Project getProjectById = projectRepository.getById(prjId);
            tableToMatch.setDeveloper(getDevById);
            tableToMatch.setProject(getProjectById);
            tableToMatchRepository.save(tableToMatch);
        }
        return false;
    }

}

