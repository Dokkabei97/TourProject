package com.t4er.web.login.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class LoginDto {

    private String userId;
    private String password;
}
