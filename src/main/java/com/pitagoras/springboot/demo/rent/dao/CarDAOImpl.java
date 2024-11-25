package com.pitagoras.springboot.demo.rent.dao;

import com.pitagoras.springboot.demo.rent.entity.Car;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CarDAOImpl implements CarDAO{

    private EntityManager entityManager;

    @Autowired
    public CarDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Car theCar) {
        entityManager.persist(theCar);
    }

    @Override
    @Transactional
    public Car findById(int id) {
        return entityManager.find(Car.class,id);
    }
}
