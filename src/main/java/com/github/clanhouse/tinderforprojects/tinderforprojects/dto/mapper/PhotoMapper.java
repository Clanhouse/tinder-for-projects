package com.github.clanhouse.tinderforprojects.tinderforprojects.dto.mapper;

import com.github.clanhouse.tinderforprojects.tinderforprojects.config.properties.ApiProperties;
import com.github.clanhouse.tinderforprojects.tinderforprojects.dto.model.photo.PhotoDTO;
import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Photo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PhotoMapper {

    private final ApiProperties apiProperties;

    public List<PhotoDTO> toPhotoDTOs(List<Photo> photos){
        List<PhotoDTO> photoDTOs = new ArrayList<>();
        for(Photo photo : photos){
            PhotoDTO photoDTO = new PhotoDTO();
            photoDTO.setId(photo.getId());
            photoDTO.setUrl(apiProperties.getUrl()+"/photos/"+photo.getHash());
            photoDTOs.add(photoDTO);
        }
        return photoDTOs;
    }

}
