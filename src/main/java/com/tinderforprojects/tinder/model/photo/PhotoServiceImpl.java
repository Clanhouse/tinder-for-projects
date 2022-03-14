package com.tinderforprojects.tinder.model.photo;

import com.tinderforprojects.tinder.exception.ErrorMessage;
import com.tinderforprojects.tinder.exception.badRequest.BadRequestException;
import com.tinderforprojects.tinder.exception.notFound.NotFoundException;
import com.tinderforprojects.tinder.model.company.CompanyRepository;
import com.tinderforprojects.tinder.model.developer.DeveloperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepository photoRepository;
    private final DeveloperRepository developerRepository;
    private final CompanyRepository companyRepository;

    @Override
    public void upload(byte[] image, Long id, String type) {
        switch (type.toLowerCase(Locale.ROOT)) {
            case "developer": {
                Photo photo = new Photo();
                photo.setDeveloper(developerRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND)));
                photo.setPhoto(image);
                photo.setHash(UUID.randomUUID().toString());
                photoRepository.save(photo);
            }
            case "company": {
                Photo photo = new Photo();
                photo.setCompany(companyRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND)));
                photo.setPhoto(image);
                photo.setHash(UUID.randomUUID().toString());
                photoRepository.save(photo);
            }
            default: {
                throw new BadRequestException(ErrorMessage.BAD_REQUEST);
            }
        }
    }

    @Override
    public byte[] download(String hash) {
        return photoRepository.findByHash(hash)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND)).getPhoto();
    }
}
