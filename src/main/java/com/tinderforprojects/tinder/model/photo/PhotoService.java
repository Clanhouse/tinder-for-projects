package com.tinderforprojects.tinder.model.photo;

public interface PhotoService {

    void upload(byte[] image, Long id, String type);

    byte[] download(String hash);

}
