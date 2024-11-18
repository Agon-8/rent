package com.pitagoras.springboot.demo.rent.rest;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;



@Component
@Primary
public class Pickup implements Car{

    public Pickup(){
        System.out.println("Constructor: "+ getClass().getName());
    }



    @Override
    public String drive() {
        return "Pikapi ma i shpejt se bmw";
    }
}
