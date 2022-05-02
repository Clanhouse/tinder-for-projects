package com.tinderforprojects.tinder.model.user.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String userName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

}
