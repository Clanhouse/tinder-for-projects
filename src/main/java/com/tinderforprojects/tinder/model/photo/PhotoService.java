package com.tinderforprojects.tinder.model.photo;

public interface PhotoService {

    void upload(byte[] image, Integer id, String type);

    byte[] download(String hash);

}
