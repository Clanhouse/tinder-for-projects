package com.tinderforprojects.tinder.model.photo;

import com.tinderforprojects.tinder.exception.ErrorMessage;
import com.tinderforprojects.tinder.exception.badRequest.BadRequestException;
import com.tinderforprojects.tinder.exception.notFound.NotFoundException;
import com.tinderforprojects.tinder.model.company.CompanyRepository;
import com.tinderforprojects.tinder.model.developer.DeveloperRepository;
import com.tinderforprojects.tinder.model.photo.dto.PhotoDto;
import com.tinderforprojects.tinder.model.photo.dto.PhotoMapper;
import com.tinderforprojects.tinder.model.project.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepository photoRepository;
    private final DeveloperRepository developerRepository;
    private final CompanyRepository companyRepository;
    private final ProjectRepository projectRepository;
    private final PhotoMapper photoMapper;

    @Override
    public boolean upload(byte[] image, Long id, String type) {
        switch (type) {
            case "developer": {
                Photo photo = new Photo();
                photo.setDeveloper(developerRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND)));
                photo.setPhoto(image);
                photo.setHash(UUID.randomUUID().toString());
                photoRepository.save(photo);
                return true;
            }
            case "company": {
                Photo photo = new Photo();
                photo.setCompany(companyRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND)));
                photo.setPhoto(image);
                photo.setHash(UUID.randomUUID().toString());
                photoRepository.save(photo);
                return true;
            }
            case "project": {
                Photo photo = new Photo();
                photo.setProject(projectRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND)));
                photo.setPhoto(image);
                photo.setHash(UUID.randomUUID().toString());
                photoRepository.save(photo);
                return true;
            }
            default:
                throw new BadRequestException(ErrorMessage.BAD_REQUEST);
        }

    }


    @Override
    public byte[] download(String hash) {
        return photoRepository.findByHash(hash)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND)).getPhoto();
    }

    @Override
    public List<PhotoDto> getPhotosUrlsByIdAndType(Long id, String type) {
        switch (type) {
            case "developer":
                return getPhotosUrlByDeveloperId(id);
            case "company":
                return getPhotosUrlByCompanyId(id);
            case "project":
                return getPhotosUrlByProjectId(id);
            default:
                throw new BadRequestException(ErrorMessage.BAD_REQUEST);
        }
    }


    private List<PhotoDto> getPhotosUrlByDeveloperId(Long id) {
        return photoMapper.toPhotosDto(
                photoRepository.findByDeveloperId(id));
    }


    private List<PhotoDto> getPhotosUrlByCompanyId(Long id) {
        return photoMapper.toPhotosDto(
                photoRepository.findByCompanyId(id));
    }


    private List<PhotoDto> getPhotosUrlByProjectId(Long id) {
        return photoMapper.toPhotosDto(
                photoRepository.findByProjectId(id));
    }
}
