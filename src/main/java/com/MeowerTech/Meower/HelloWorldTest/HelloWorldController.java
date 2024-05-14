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
    public HelloWorld hello(@RequestHeader String token) {
        // TODO! extract jwt token from the request header Authorization
        String username = jwtService.extractUsername(token);
    return new HelloWorld("Hello to my man " + username);
    }
}
