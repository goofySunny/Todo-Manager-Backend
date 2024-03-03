package com.MeowerTech.Meower.BasicAuth;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BasicAuthController {

    @GetMapping(path = "/basicAuth")
    public BasicAuthBean hello() {
//        throw new RuntimeException("Something went wrong contact support at meow meow meow");
        return new BasicAuthBean("You are Authenticated!");
    }
}
