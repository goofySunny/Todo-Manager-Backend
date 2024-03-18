package com.MeowerTech.Meower.Auth;

public interface AuthenticationService {

    AuthenticationResponse register(AuthenticationRequest.RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

}