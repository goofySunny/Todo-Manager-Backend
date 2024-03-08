package com.MeowerTech.Meower.Auth;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AuthenticationResponse {

    private String username;
    private String token;

}
