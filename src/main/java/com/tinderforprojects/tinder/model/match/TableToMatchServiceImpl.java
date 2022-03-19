package com.tinderforprojects.tinder.model.match;

import com.tinderforprojects.tinder.exception.ErrorMessage;
import com.tinderforprojects.tinder.exception.notFound.NotFoundException;
import com.tinderforprojects.tinder.model.developer.Developer;
import com.tinderforprojects.tinder.model.developer.DeveloperRepository;
import com.tinderforprojects.tinder.model.match.dto.TableToMatchDto;
import com.tinderforprojects.tinder.model.project.Project;
import com.tinderforprojects.tinder.model.project.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TableToMatchServiceImpl implements TableToMatchService {

    private final TableToMatchRepository tableToMatchRepository;
    private final DeveloperRepository developerRepository;
    private final ProjectRepository projectRepository;

    @Override
    public boolean like(TableToMatchDto tableToMatchDto) {
        Long devId = tableToMatchDto.getIdDeveloper();
        Long prjId = tableToMatchDto.getIdProject();
        Optional<TableToMatch> tableToMatchOptional =
                tableToMatchRepository.findByDeveloperIdAndProjectId(devId, prjId);

        if (tableToMatchOptional.isPresent()) {
            TableToMatch tableToMatch = tableToMatchOptional.get();
            if (tableToMatch.isLike()) {
                tableToMatch.setMatch(true);
                tableToMatchRepository.save(tableToMatch);
                return true;
            } else {
                return false;
            }

        } else {
            TableToMatch tableToMatch = new TableToMatch();
            Developer getDevById = developerRepository.findById(devId)
                    .orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND));
            Project getProjectById = projectRepository.findById(prjId)
                    .orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND));
            tableToMatch.setDeveloper(getDevById);
            tableToMatch.setProject(getProjectById);
            tableToMatchRepository.save(tableToMatch);
        }
        return false;
    }

    @Override
    public boolean unLike(TableToMatchDto tableToMatchDto) {
        Long devId = tableToMatchDto.getIdDeveloper();
        Long prjId = tableToMatchDto.getIdProject();

        Optional<TableToMatch> tableToMatchOptional =
                tableToMatchRepository.findByDeveloperIdAndProjectId(devId, prjId);
        TableToMatch tableToMatch;
        if (tableToMatchOptional.isPresent()) {
            tableToMatch = tableToMatchOptional.get();
        } else {
            tableToMatch = new TableToMatch();
            Developer getDevById = developerRepository.findById(devId)
                    .orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND));
            Project getProjectById = projectRepository.findById(prjId)
                    .orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND));
            tableToMatch.setDeveloper(getDevById);
            tableToMatch.setProject(getProjectById);
        }
        tableToMatch.setMatch(false);
        tableToMatch.setLike(false);
        tableToMatchRepository.save(tableToMatch);
        return false;
    }

    @Override
    public List<Developer> findAllLikedDevelopersByProjectId(Long id) {
        return tableToMatchRepository.getAllLikedDevsByProjectId(id);
    }

    @Override
    public List<Project> findAllLikedProjectsByDeveloperId(Long id) {
        return tableToMatchRepository.getAllLikedProjectsByDevId(id);
    }
}
