package com.github.clanhouse.tinderforprojects.tinderforprojects.restController;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.company.CompanyDTO;

import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ResourceNotFoundException;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompaniesController {

    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> findAll(){
        List<CompanyDTO> companyDTOs = companyService.findAll();
        if(companyDTOs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> findById(@PathVariable Integer id){
        try{
            CompanyDTO companyDTO = companyService.findById(id);
            return new ResponseEntity<>(companyDTO, HttpStatus.OK);
        }catch (ResourceNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CompanyDTO> create(@RequestBody CompanyDTO companyDTO){
        try{
            companyService.create(companyDTO);
            return new ResponseEntity<>(companyDTO, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<CompanyDTO> update(@RequestBody CompanyDTO companyDTO){
        if(companyService.isExistById(companyDTO.getId())){
            try{
                companyService.create(companyDTO);
                return new ResponseEntity<>(companyDTO, HttpStatus.OK);
            }catch (Exception e){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


}
