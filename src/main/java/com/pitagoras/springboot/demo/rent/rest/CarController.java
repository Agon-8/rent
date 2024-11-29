package com.pitagoras.springboot.demo.rent.rest;

import com.pitagoras.springboot.demo.rent.dao.CarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pitagoras.springboot.demo.rent.entity.Car;

import java.util.List;

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

        return "Car was created susscessfully " + car.getId() ;
    }
    @GetMapping("/find-car")
    public String findById(){
        return this.carDAO.findById(3).toString();
    }

    @GetMapping("/update-car")
    public String updateCar() {
        Car car = this.carDAO.findById(4);

        if (car == null) {
            return "Car with the id 2 not found";
        }

        car.setMake("Peugeot");
        car.setModel("3008");
        car.setColor("Blue");
        car.setYear(2020);
        car.setAvailable(true);
        car.setLicensePlate("01-112-MK");
        carDAO.updateCar(car);

        return "Car updated successfully with id: " + car.getId();
    }
    @GetMapping("/delete-car")
    public String deleteCar(){
        Car car = this.carDAO.findById(1);
        if (car == null){
            return "Car with the id 1 not found";
        }
        carDAO.deleteCar(car);
        return "Car was deleted susscessfully";
    }
    @GetMapping("/findAll-car")
    public String findAll(){
        List<Car> cars = this.carDAO.findAll();
        String response = ",";
        for (Car car :cars ){
            response += car.toString() + "\n";

        }
        return response;
    }
}
