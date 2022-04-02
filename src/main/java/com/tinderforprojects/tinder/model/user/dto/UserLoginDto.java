package com.tinderforprojects.tinder.model.user.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {

    private String userName;
    private String password;
}
