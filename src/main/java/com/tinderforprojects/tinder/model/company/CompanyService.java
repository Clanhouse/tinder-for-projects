package com.tinderforprojects.tinder.model.company;

import com.tinderforprojects.tinder.model.photo.dto.PhotoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();

    Company findById(Long id);

    Company create(Company company);

    Company update(Long id, String name);

    List<PhotoDto> downloadPhotos(Long id);

    ResponseEntity<String> uploadPhoto(byte[] image, Long id);
}
