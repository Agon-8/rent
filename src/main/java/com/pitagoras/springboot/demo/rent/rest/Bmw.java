package com.pitagoras.springboot.demo.rent.rest;

import org.springframework.stereotype.Component;

@Component
public class Bmw implements Car {

    public Bmw(){
        System.out.println("Constructor: "+ getClass().getName());
    }


    @Override
    public String drive() {
        return "Driving BMW 100 km/h";
    }
}
