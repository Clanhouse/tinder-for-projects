package com.github.clanhouse.tinderforprojects.tinderforprojects.service;


import com.github.clanhouse.tinderforprojects.tinderforprojects.entities.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PhotoService {

    void upload(byte[] image, Integer id, String type);

    byte[] download(String hash);

}
