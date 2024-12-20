package com.pitagoras.springboot.demo.rent.rest;

import com.pitagoras.springboot.demo.rent.dao.CarRepository;
import com.pitagoras.springboot.demo.rent.entity.Car;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars-jpa")
public class CarJpaController {

    private final CarRepository carRepository;

    @Autowired
    public CarJpaController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @GetMapping("/list")
    public List<Car> findAll() {
        List<Car> cars = this.carRepository.findAll();
        return cars;
    }

    @PostMapping()
    public Car save(@RequestBody Car carRequest) {

        return this.carRepository.save(carRequest);
    }

    @GetMapping("/find/{carId}")
    public Car findById(@PathVariable int carId) {

        Optional<Car> vetura = this.carRepository.findById(carId);

        if (!vetura.isPresent()) {
            throw new CarNotFoundException("Car with id " + carId + " not found.");
        }
        return vetura.get();

    }

    @PutMapping("/{id}")
    public Car updateCar(@RequestBody Car car, @PathVariable int id) {
        Optional<Car> toUpdatedCar = this.carRepository.findById(id);
        if (toUpdatedCar == null) {
            throw new CarNotFoundException("Car with id " + id + " not found to update");
        }
        car.setId(id);
        this.carRepository.save(car);
        return toUpdatedCar.get();
    }

    @DeleteMapping("/{id}")
    public boolean deleteCar(@PathVariable int id) {
        Optional<Car> car = this.carRepository.findById(id);
        if (car == null) {
            throw new CarNotFoundException("Car with id " + id + " was not found");
        }
        carRepository.deleteById(id);
        return true;
    }

    @GetMapping("/find-car-plate/{licensePlate}")
    public Car findByPlate(@PathVariable String licensePlate) {
        List<Car> vetura = this.carRepository.findByLicensePlate(licensePlate);
        if (vetura.size() == 0) {
            throw new CarNotFoundException("Car with licensePlate " + licensePlate + " not found.");
        }
        return vetura.get(0);

    }

}

