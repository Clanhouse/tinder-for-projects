package com.tinderforprojects.tinder.api;

import com.tinderforprojects.tinder.model.photo.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/photos")
public class PhotoController {

    private final PhotoService photoService;

    @GetMapping(value = "/{hash}",
            produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] download(@PathVariable String hash) {
        return photoService.download(hash);
    }

}
