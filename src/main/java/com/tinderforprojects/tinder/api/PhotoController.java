package com.tinderforprojects.tinder.api;

import com.tinderforprojects.tinder.model.photo.PhotoService;
import com.tinderforprojects.tinder.model.photo.dto.PhotoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/photos")
public class PhotoController {

    private final PhotoService photoService;

    @PostMapping("/{id}/{type}")
    public void upload(@RequestBody byte[] image, @PathVariable Long id, @PathVariable String type) {
        photoService.upload(image, id, type);
    }

    @GetMapping(value = "/{hash}",
            produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] download(@PathVariable String hash) {
        return photoService.download(hash);
    }

    @GetMapping("/{id}/{type}")
    public List<PhotoDto> getPhotosUrlsByIdAndType(@PathVariable Long id, @PathVariable String type){
        return photoService.getPhotosUrlsByIdAndType(id, type);
    }


}
