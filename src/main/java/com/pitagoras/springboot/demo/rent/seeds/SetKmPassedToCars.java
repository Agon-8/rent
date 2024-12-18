package com.pitagoras.springboot.demo.rent.seeds;

import com.pitagoras.springboot.demo.rent.dao.CarDAOImpl;
import com.pitagoras.springboot.demo.rent.entity.Car;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SetKmPassedToCars implements ApplicationRunner {

    private final EntityManager entityManager;

    @Autowired
    public SetKmPassedToCars(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        CarDAOImpl repository = new CarDAOImpl(this.entityManager);

        List<Car> cars = repository.findAll();
        for (Car car : cars){
            System.out.println(car);
        }
    }
}
