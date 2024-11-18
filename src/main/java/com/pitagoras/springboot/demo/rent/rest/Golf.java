package com.pitagoras.springboot.demo.rent.rest;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component
@Lazy
public class Golf implements Car{

    public Golf(){
        System.out.println("Constructor: "+ getClass().getName());
    }

    @Override
    public String drive() {
        return "Driving golf 200 km/h";
    }
}
