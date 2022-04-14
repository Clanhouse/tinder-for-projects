package com.tinderforprojects.tinder.api;

import com.tinderforprojects.tinder.model.company.CompanyService;
import com.tinderforprojects.tinder.model.company.dto.CompanyDTO;
import com.tinderforprojects.tinder.model.company.dto.CompanyMapper;
import com.tinderforprojects.tinder.model.photo.dto.PhotoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {
    
    private final CompanyService companyService;
    private final CompanyMapper companyMapper;

    @GetMapping
    public List<CompanyDTO> findAll() {
        return companyMapper.toCompanyDTOs(
                companyService.findAll());
    }

    @GetMapping("/{id}")
    public CompanyDTO findById(@PathVariable Long id) {
        return companyMapper.toCompanyDTO(
                companyService.findById(id));
    }

    @PostMapping
    public CompanyDTO create(@RequestBody CompanyDTO companyDto) {
        return companyMapper.toCompanyDTO(
                companyService.create(
                        companyMapper.toCompany(companyDto)
                ));
    }

    @PutMapping("/{id}")
    public CompanyDTO update(@PathVariable Long id, @RequestBody String name) {
        return companyMapper.toCompanyDTO(
                companyService.update(id, name));
    }

    @GetMapping("/{id}/photos")
    public List<PhotoDto> getPhotosByCompanyId(@PathVariable Long id) {
        return companyService.downloadPhotos(id);
    }

    @PutMapping("/{id}/photos")
    public ResponseEntity<String> uploadPhoto(@RequestBody byte[] image, @PathVariable Long id) {
        return companyService.uploadPhoto(image, id);
    }
}
