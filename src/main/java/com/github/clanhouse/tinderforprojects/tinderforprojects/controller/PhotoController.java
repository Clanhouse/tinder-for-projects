package com.github.clanhouse.tinderforprojects.tinderforprojects.controller;


import com.github.clanhouse.tinderforprojects.tinderforprojects.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/photos")
@RequiredArgsConstructor
public class PhotoController {

    private final PhotoService photoService;

    @PostMapping("/{type}/{id}")
    public void upload(@RequestBody byte[] image, @PathVariable Integer id, @PathVariable String type) {
        photoService.upload(image, id, type);
    }

    @GetMapping(value = "/{hash}",
            produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] download(@PathVariable String hash) {
        return photoService.download(hash);
    }


}
