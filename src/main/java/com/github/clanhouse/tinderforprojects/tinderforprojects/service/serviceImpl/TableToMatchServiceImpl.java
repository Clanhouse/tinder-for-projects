package com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.match.ProjectDevDto;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Developer;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Project;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.TableToMatch;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ControllerError;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ControllerException;
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


    public boolean like(ProjectDevDto projectDevDto) {
        Integer devId = projectDevDto.getIdDev();
        Integer prjId = projectDevDto.getIdProject();
        Optional<TableToMatch> tableToMatchOptional =
                tableToMatchRepository.findByDeveloperIdAndProjectId(devId, prjId);

        if (tableToMatchOptional.isPresent()) {
            TableToMatch tableToMatch = tableToMatchOptional.get();
            if(tableToMatch.isLike()){
                tableToMatch.setMatch(true);
                tableToMatchRepository.save(tableToMatch);
                return true;
            } else {
                return false;
            }

        } else {
            TableToMatch tableToMatch = new TableToMatch();
            Developer getDevById = developerRepository.findById(devId)
                    .orElseThrow(() -> new ControllerException(ControllerError.NOT_FOUND));
            Project getProjectById = projectRepository.findById(prjId)
                    .orElseThrow(() -> new ControllerException(ControllerError.NOT_FOUND));
            tableToMatch.setDeveloper(getDevById);
            tableToMatch.setProject(getProjectById);
            tableToMatchRepository.save(tableToMatch);
        }
        return false;
    }

    public boolean unLike(ProjectDevDto projectDevDto) {
        Integer developerId = projectDevDto.getIdDev();
        Integer projectId = projectDevDto.getIdProject();

        Optional<TableToMatch> tableToMatchOptional =
                tableToMatchRepository.findByDeveloperIdAndProjectId(developerId, projectId);
        TableToMatch tableToMatch;
        if (tableToMatchOptional.isPresent()) {
            tableToMatch = tableToMatchOptional.get();
        } else {
            tableToMatch = new TableToMatch();
            Developer getDevById = developerRepository.findById(developerId)
                    .orElseThrow(() -> new ControllerException(ControllerError.NOT_FOUND));
            Project getProjectById = projectRepository.findById(projectId)
                    .orElseThrow(() -> new ControllerException(ControllerError.NOT_FOUND));
            tableToMatch.setDeveloper(getDevById);
            tableToMatch.setProject(getProjectById);
        }
        tableToMatch.setMatch(false);
        tableToMatch.setLike(false);
        tableToMatchRepository.save(tableToMatch);
        return false;
    }

}

