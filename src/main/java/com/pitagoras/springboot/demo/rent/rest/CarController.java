package com.pitagoras.springboot.demo.rent.rest;

import com.pitagoras.springboot.demo.rent.dao.CarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pitagoras.springboot.demo.rent.entity.Car;

@RestController
public class CarController {

    private CarDAO carDAO;

    @Autowired
    public CarController( CarDAO carDAO){
        this.carDAO = carDAO;
    }

    @GetMapping("/save-car")
    public String save(){
        Car car = new Car();
        car.setModel("M5");
        car.setMake("BMW");
        car.setColor("BLue");

        this.carDAO.save(car);

        return "Car was created sussceesfully " + car.getId() ;
    }
    @GetMapping("/find-car")
    public String findById(){
        return this.carDAO.findById(2).toString();
    }
}
