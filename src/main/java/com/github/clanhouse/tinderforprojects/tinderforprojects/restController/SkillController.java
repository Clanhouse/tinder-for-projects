package com.github.clanhouse.tinderforprojects.tinderforprojects.restController;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.skill.SkillDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ResourceNotFoundException;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/skill")
public class SkillController {

    private final SkillService skillService;

    @GetMapping
    public ResponseEntity<List<SkillDTO>> findAll(){
        List<SkillDTO> skillDTOS = skillService.findAll();
        if(skillDTOS.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(skillDTOS, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillDTO> findById(@PathVariable Integer id){
        try{
            SkillDTO skillDTO = skillService.findById(id);
            return new ResponseEntity<>(skillDTO, HttpStatus.OK);
        }catch (ResourceNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<SkillDTO> create(@RequestBody SkillDTO skillDTO){
        try{
            skillService.create(skillDTO);
            return new ResponseEntity<>(skillDTO, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<SkillDTO> update(@RequestBody SkillDTO skillDTO){
        if(skillService.isExistById(skillDTO.getId())){
            try{
                skillService.create(skillDTO);
                return new ResponseEntity<>(skillDTO, HttpStatus.OK);
            }catch (Exception e){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
