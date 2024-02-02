package com.MeowerTech.Meower.Controller;


import com.MeowerTech.Meower.Models.HelloWorld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello")
    public HelloWorld hello() {
        return new HelloWorld("Hello World");
    }
}
