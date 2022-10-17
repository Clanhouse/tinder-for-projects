package com.example.matchservice.controller;

import com.example.matchservice.model.Like;
import com.example.matchservice.service.MatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class MatchController {

    //TODO EXCEPTION HANDLING

    private final MatchService matchService;

    @GetMapping
    public boolean isMatch(@RequestParam Long developerId, @RequestParam Long projectId) {
        log.debug("Processing isMatch request developerId: {}, projectId: {}", developerId, projectId);
        return matchService.isMatch(developerId, projectId);
    }

    @PostMapping("/like")
    public boolean like(@RequestBody Like like) {
        log.debug("Processing like request {}", like);
        return matchService.like(like);
    }

    @PostMapping("/unlike")
    public boolean unlike(@RequestBody Like like) {
        log.debug("Processing unlike request {}", like);
        return matchService.unLike(like);
    }
}
