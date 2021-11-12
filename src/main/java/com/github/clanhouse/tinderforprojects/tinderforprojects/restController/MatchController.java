package com.github.clanhouse.tinderforprojects.tinderforprojects.restController;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.match.ProjectDevDto;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Developer;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Project;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.TableToMatch;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.CompanyRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.DeveloperRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.ProjectRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.TableToMatchRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.TableToMatchService;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl.TableToMatchServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/match")
@RequiredArgsConstructor
@ResponseStatus(HttpStatus.OK)
public class MatchController {

    private final TableToMatchServiceImpl tableToMatchService;

    @PostMapping
    public boolean match(@RequestBody ProjectDevDto projectDevDto){
        return tableToMatchService.match(projectDevDto);
    }

}

