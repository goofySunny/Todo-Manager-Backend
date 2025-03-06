package com.MeowerTech.Meower.model;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AuthenticationResponse {

    private String username;
    private String token;

}
