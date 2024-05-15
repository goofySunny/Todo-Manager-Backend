package com.MeowerTech.Meower.HelloWorldTest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.MeowerTech.Meower.config.JwtService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
public class HelloWorldController {

    @Autowired
    private final JwtService jwtService;

//     @GetMapping(path = "/hello")
//     public HelloWorld hello() {
// //        throw new RuntimeException("Something went wrong contact support at meow meow meow");
//         return new HelloWorld("Meow World");
//     }



    @GetMapping(path = "/hello")
    public HelloWorld hello(@RequestHeader(name = "Authorization") String token) {
        String jwt = token.substring(7);
        String username = jwtService.extractUsername(jwt);
    return new HelloWorld("Hello to my man " + username);
    }
}
