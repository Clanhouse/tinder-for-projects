package com.tinderforprojects.tinder.model.photo;

import com.tinderforprojects.tinder.model.photo.dto.PhotoDto;

import java.util.List;

public interface PhotoService {

    boolean upload(byte[] image, Long id, String type);

    byte[] download(String hash);

   List<PhotoDto> getPhotosUrlsByIdAndType(Long id, String type);

}
