package com.github.clanhouse.tinderforprojects.tinderforprojects.restController;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.achievement.AchievementDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.company.CompanyDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ResourceNotFoundException;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.AchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/achievement")
public class AchievementController {

    private final AchievementService achievementService;

    @GetMapping
    public ResponseEntity<List<AchievementDTO>> findAll(){
        List<AchievementDTO> achievementDTOS = achievementService.findAll();
        if(achievementDTOS.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(achievementDTOS, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AchievementDTO> findById(@PathVariable Integer id){
        try{
            AchievementDTO achievementDTO = achievementService.findById(id);
            return new ResponseEntity<>(achievementDTO, HttpStatus.OK);
        }catch (ResourceNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<AchievementDTO> create(@RequestBody AchievementDTO achievementDTO){
        try{
            achievementService.create(achievementDTO);
            return new ResponseEntity<>(achievementDTO, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<AchievementDTO> update(@RequestBody AchievementDTO achievementDTO){
        if(achievementService.isExistById(achievementDTO.getId())){
            try{
                achievementService.create(achievementDTO);
                return new ResponseEntity<>(achievementDTO, HttpStatus.OK);
            }catch (Exception e){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
