package com.pitagoras.springboot.demo.rent.dao;


import com.pitagoras.springboot.demo.rent.entity.Car;

public interface CarDAO {
    void save(Car theCar );

    Car findById(int id );
}
