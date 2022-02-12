package com.github.clanhouse.tinderforprojects.tinderforprojects.service.serviceImpl;

import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Photo;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ControllerError;
import com.github.clanhouse.tinderforprojects.tinderforprojects.exception.ControllerException;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.CompanyRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.DeveloperRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.repository.PhotoRepository;
import com.github.clanhouse.tinderforprojects.tinderforprojects.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepository photoRepository;
    private final DeveloperRepository developerRepository;
    private final CompanyRepository companyRepository;

    @Override
    public void upload(byte[] image, Integer id, String type) {
        if (type.equals("developer")) {
            Photo photo = new Photo();
            photo.setDeveloper(developerRepository.findById(id)
                    .orElseThrow(() -> new ControllerException(ControllerError.NOT_FOUND)));
            photo.setPhoto(image);
            photo.setHash(UUID.randomUUID().toString());
            photoRepository.save(photo);
        } else if (type.equals("company")) {
            Photo photo = new Photo();
            photo.setCompany(companyRepository.findById(id)
                    .orElseThrow(() -> new ControllerException(ControllerError.NOT_FOUND)));
            photo.setPhoto(image);
            photo.setHash(UUID.randomUUID().toString());
            photoRepository.save(photo);
        }
    }

    @Override
    public byte[] download(String hash) {
        return photoRepository.findByHash(hash)
                .orElseThrow(() -> new ControllerException(ControllerError.NOT_FOUND)).getPhoto();
    }

}
