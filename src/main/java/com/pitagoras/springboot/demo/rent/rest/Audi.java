package com.pitagoras.springboot.demo.rent.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class Audi implements Car{

    @Bean
    public Car audi(){
        System.out.println("Constructor: "+ getClass().getName());
        return new Audi() ;
    }

    @Override
    public String drive() {
        return "Audi is the best";
    }
}
