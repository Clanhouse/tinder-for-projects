package com.github.clanhouse.tinderforprojects.tinderforprojects.restController;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.developer.DeveloperDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ResourceNotFoundException;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/developer")
public class DeveloperController {

    private final DeveloperService developerService;

    @GetMapping
    public ResponseEntity<List<DeveloperDTO>> findAll(){
        List<DeveloperDTO> developerDTOS = developerService.findAll();
        if(developerDTOS.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(developerDTOS, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeveloperDTO> findById(@PathVariable Integer id){
        try{
            DeveloperDTO developerDTO = developerService.findById(id);
            return new ResponseEntity<>(developerDTO, HttpStatus.OK);
        }catch (ResourceNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/random")
    public ResponseEntity<DeveloperDTO> findRandom(){
        return new ResponseEntity<>(developerService.findRandom(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DeveloperDTO> create(@RequestBody DeveloperDTO developerDTO){
        try{
            developerService.create(developerDTO);
            return new ResponseEntity<>(developerDTO, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<DeveloperDTO> update(@RequestBody DeveloperDTO developerDTO){
        if(developerService.isExistById(developerDTO.getId())){
            try{
                developerService.create(developerDTO);
                return new ResponseEntity<>(developerDTO, HttpStatus.OK);
            }catch (Exception e){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    }

