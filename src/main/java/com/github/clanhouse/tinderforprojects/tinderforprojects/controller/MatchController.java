package com.github.clanhouse.tinderforprojects.tinderforprojects.controller;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.match.ProjectDevDto;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl.TableToMatchServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/match")
@RequiredArgsConstructor
@ResponseStatus(HttpStatus.OK)
public class MatchController {

    private final TableToMatchServiceImpl tableToMatchService;

    @PostMapping("/like")
    public boolean like(@RequestBody ProjectDevDto projectDevDto){
        return tableToMatchService.like(projectDevDto);
    }

    @PostMapping("/unlike")
    public boolean unLike(@RequestBody ProjectDevDto projectDevDto){
        return tableToMatchService.unLike(projectDevDto);
    }

}

