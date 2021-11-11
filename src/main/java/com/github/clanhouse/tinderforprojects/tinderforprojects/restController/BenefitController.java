package com.github.clanhouse.tinderforprojects.tinderforprojects.restController;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.benefit.BenefitDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ResourceNotFoundException;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.BenefitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/benefit")
public class BenefitController {

    private final BenefitService benefitService;

    @GetMapping
    public ResponseEntity<List<BenefitDTO>> findAll(){
        List<BenefitDTO> benefitDTOS = benefitService.findAll();
        if(benefitDTOS.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(benefitDTOS, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BenefitDTO> findById(@PathVariable Integer id){
        try{
            BenefitDTO benefitDTO = benefitService.findById(id);
            return new ResponseEntity<>(benefitDTO, HttpStatus.OK);
        }catch (ResourceNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<BenefitDTO> create(@RequestBody BenefitDTO benefitDTO){
        try{
            benefitService.create(benefitDTO);
            return new ResponseEntity<>(benefitDTO, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<BenefitDTO> update(@RequestBody BenefitDTO benefitDTO){
        if(benefitService.isExistById(benefitDTO.getId())){
            try{
                benefitService.create(benefitDTO);
                return new ResponseEntity<>(benefitDTO, HttpStatus.OK);
            }catch (Exception e){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
