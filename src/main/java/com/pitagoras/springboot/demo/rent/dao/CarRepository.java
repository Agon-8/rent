package com.pitagoras.springboot.demo.rent.dao;

import com.pitagoras.springboot.demo.rent.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {
    @Query("select c from Car c where c.licensePlate = :licensePlate")
    List<Car> findByLicensePlate(@Param("licensePlate") String licensePlate);
}
