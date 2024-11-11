package com.pitagoras.springboot.demo.rent.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello world!";
    }

    @GetMapping("/about")
    public String tellAboutApp(){
        return "This is an app we are creating for learning purposes.!";
    }

    @GetMapping("/devtools")
    public String testing(){
        return "This should work";
    }
    @GetMapping("/test")
    public String test(){
        return "Test 1";
    }
}
