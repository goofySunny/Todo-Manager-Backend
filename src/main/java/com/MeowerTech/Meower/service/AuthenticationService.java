package com.MeowerTech.Meower.service;

import com.MeowerTech.Meower.model.AuthenticationRequest;
import com.MeowerTech.Meower.model.AuthenticationResponse;

public interface AuthenticationService {

    AuthenticationResponse register(AuthenticationRequest.RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

}