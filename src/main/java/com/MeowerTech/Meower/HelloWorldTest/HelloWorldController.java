package com.MeowerTech.Meower.HelloWorldTest;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello")
    public HelloWorld hello() {
//        throw new RuntimeException("Something went wrong contact support at meow meow meow");
        return new HelloWorld("Meow World");
    }



    @GetMapping(path = "/hello/{name}")
    public HelloWorld hello(@PathVariable String name) {
//        throw new RuntimeException("Something went wrong contact support at meow meow meow");
        return new HelloWorld("Hello to my man " + name);
    }
}
