package com.pitagoras.springboot.demo.rent.rest;

import com.pitagoras.springboot.demo.rent.dao.CarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pitagoras.springboot.demo.rent.entity.Car;

import java.util.List;

@RestController
public class CarController {

    private CarDAO carDAO;

    @Autowired
    public CarController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping("/save-car/{make}/{model}/{color}")
    public Car save(@PathVariable String make, @PathVariable String model, @PathVariable String color) {
        Car car = new Car();
        car.setModel(model);
        car.setMake(make);
        car.setColor(color);

        this.carDAO.save(car);

        return this.carDAO.findById(car.getId());
    }

    @GetMapping("/find-car/{carId}")
    public Car findById(@PathVariable int carId) {

        Car vetura = this.carDAO.findById(carId);
        if (vetura == null) {
            throw new CarNotFoundException("Car with id " + carId + " not found.");
        }
        return vetura;

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
    public String deleteCar() {
        Car car = this.carDAO.findById(1);
        if (car == null) {
            return "Car with the id 1 not found";
        }
        carDAO.deleteCar(car);
        return "Car was deleted susscessfully";
    }

    @GetMapping("/findAll-car")
    public List<Car> findAll() {
        List<Car> cars = this.carDAO.findAll();
        return cars;
    }

    @GetMapping("/test-html")
    public String testingHtml() {
        return "<h1>Pitagoras sasad</h1>" +
                "<button>Kliko ketu</button>";

    }

}
