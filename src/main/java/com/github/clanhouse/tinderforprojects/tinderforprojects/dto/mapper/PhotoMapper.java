package com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper;

import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.photo.PhotoDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Photo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PhotoMapper {

    public List<PhotoDTO> toPhotoDTOs(List<Photo> photos){
        List<PhotoDTO> photoDTOs = new ArrayList<>();
        for(Photo photo : photos){
            PhotoDTO photoDTO = new PhotoDTO();
            photoDTO.setId(photo.getId());
            photoDTO.setUrl("http://localhost:8080/photos/"+photo.getHash());
            photoDTOs.add(photoDTO);
        }
        return photoDTOs;
    }

}
