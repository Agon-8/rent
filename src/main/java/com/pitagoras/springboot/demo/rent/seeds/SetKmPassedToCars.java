package com.pitagoras.springboot.demo.rent.seeds;

import com.pitagoras.springboot.demo.rent.dao.CarDAOImpl;
import com.pitagoras.springboot.demo.rent.entity.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;
import java.util.Random;

@Configuration
@EnableTransactionManagement
public class SetKmPassedToCars implements ApplicationRunner {

    private final EntityManager entityManager;

    @Autowired
    public SetKmPassedToCars(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        CarDAOImpl repository = new CarDAOImpl(this.entityManager);

//        Random rand = new Random();

//        List<Car> cars = repository.findAll();
       // cars.get(0).setKmPassed(123400);
//        repository.findById(1);
//        repository.findById(2);
       // Query toExecute =  this.entityManager.createQuery("update Car set kmPassed = 12400 where id = 3");
      //  repository.updateCar(cars.get(0));

     //   toExecute.executeUpdate();
//        for (Car car : cars){
//            repository = new CarDAOImpl(this.entityManager);
//            int kmPassed = rand.nextInt(10000,200000);
//            System.out.println(kmPassed);
//            System.out.println(car);
//            car.setKmPassed(kmPassed);
//            repository.updateCar(car);
//        }
    }
}
