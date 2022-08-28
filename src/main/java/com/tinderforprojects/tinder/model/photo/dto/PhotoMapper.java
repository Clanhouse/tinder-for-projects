package com.tinderforprojects.tinder.model.photo.dto;

import com.tinderforprojects.tinder.config.applicationProperties.ApplicationProperties;
import com.tinderforprojects.tinder.model.photo.Photo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PhotoMapper {

    private final ApplicationProperties applicationProperties;

    public List<PhotoDto> toPhotosDto(List<Photo> photos) {
        List<PhotoDto> photosDto = new ArrayList<>();
        for(Photo photo : photos) {
            photosDto.add(PhotoDto.builder()
                    .id(photo.getId())
                    .url(String.format("%s/photos/%s",applicationProperties.getUrl(), photo.getHash()))
                    .build());
        }
        return photosDto;
    }



}
