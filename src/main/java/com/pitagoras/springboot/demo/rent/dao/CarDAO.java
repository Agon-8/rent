package com.pitagoras.springboot.demo.rent.dao;


import com.pitagoras.springboot.demo.rent.entity.Car;

import java.util.List;

public interface CarDAO {

    void save(Car theCar );

    Car findById(int id );

    void updateCar(Car theCar);

    void deleteCar(Car theCar);

    List<Car> findAll();

    Car find(String licensePlate);
}
