package com.pitagoras.springboot.demo.rent.rest;

import com.pitagoras.springboot.demo.rent.repository.CarRepository;
import com.pitagoras.springboot.demo.rent.entity.Car;
import com.pitagoras.springboot.demo.rent.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarRepository carRepository;
    private final CarService carService;

    @Autowired
    public CarController(CarRepository carRepository, CarService carService) {
        this.carRepository = carRepository;
        this.carService = carService;
    }

    @PostMapping()
    public Car save(@RequestBody Car car) {
        return this.carService.save(car);
    }

    @GetMapping("/find/{carId}")
    public Car findById(@PathVariable int carId) {
        return carService.findById(carId);
    }

    @PutMapping("/{id}")
    public Car updateCar(@RequestBody Car car,@PathVariable int id) {
        Car toUpdateCar = this.carService.findById(id);
        if(toUpdateCar == null){
            throw new RuntimeException("Car with id "+ id + "not found to update");
        }
        car.setId(id);
        return this.carService.updateCar(car);
    }

    @GetMapping("/list")
    public List<Car> findAll() {
        return this.carService.findAll();
    }

    @GetMapping("/find-car-plate/{licensePlate}")
    public Car findByPlate(@PathVariable String licensePlate) {
        return carService.findByLicensePlate(licensePlate);

    }

    @DeleteMapping("/{id}")
    public boolean deleteCar(@PathVariable int id) {
        return carService.deleteById(id);
    }
}

