package com.tinderforprojects.tinder.model.photo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class PhotoDto {

    private Long id;
    private String url;
}
