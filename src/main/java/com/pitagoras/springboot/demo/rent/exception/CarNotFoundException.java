package com.pitagoras.springboot.demo.rent.exception;

public class CarNotFoundException extends RuntimeException{

    public CarNotFoundException(String message){
        super(message);
    }
}
