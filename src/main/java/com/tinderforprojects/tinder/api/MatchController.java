package com.tinderforprojects.tinder.api;

import com.tinderforprojects.tinder.model.match.TableToMatchServiceImpl;
import com.tinderforprojects.tinder.model.match.dto.TableToMatchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/match")
public class MatchController {

    private final TableToMatchServiceImpl tableToMatchService;

    @PostMapping("/like")
    public boolean like(@RequestBody TableToMatchDto tableToMatchDto){
        return tableToMatchService.like(tableToMatchDto);
    }

    @PostMapping("/unlike")
    public boolean unLike(@RequestBody TableToMatchDto tableToMatchDto){
        return tableToMatchService.unLike(tableToMatchDto);
    }

}
