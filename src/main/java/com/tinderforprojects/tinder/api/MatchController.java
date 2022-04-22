package com.tinderforprojects.tinder.api;

import com.tinderforprojects.tinder.model.developer.Developer;
import com.tinderforprojects.tinder.model.developer.dto.DeveloperDTO;
import com.tinderforprojects.tinder.model.developer.dto.DeveloperMapper;
import com.tinderforprojects.tinder.model.match.TableToMatchServiceImpl;
import com.tinderforprojects.tinder.model.match.dto.TableToMatchDto;
import com.tinderforprojects.tinder.model.project.dto.ProjectDTO;
import com.tinderforprojects.tinder.model.project.dto.ProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/match")
public class MatchController {

    private final TableToMatchServiceImpl tableToMatchService;
    private final DeveloperMapper developerMapper;
    private final ProjectMapper projectMapper;

    @PostMapping("/like")
    public boolean like(@RequestBody TableToMatchDto tableToMatchDto){
        return tableToMatchService.like(tableToMatchDto);
    }

    @PostMapping("/unlike")
    public boolean unLike(@RequestBody TableToMatchDto tableToMatchDto){
        return tableToMatchService.unLike(tableToMatchDto);
    }

    @GetMapping("/developers/{projectId}")
    public List<DeveloperDTO> findLikedDevelopersByProjectId(@PathVariable Long projectId) {
        return developerMapper.toDeveloperDTOs(
                tableToMatchService.findAllLikedDevelopersByProjectId(projectId));
    }

    @GetMapping("/projects/{developerId}")
    public List<ProjectDTO> findLikedProjectsByDeveloperId(@PathVariable Long developerId) {
        return projectMapper.toProjectDTOs(
                tableToMatchService.findAllLikedProjectsByDeveloperId(developerId));
    }

}
