package com.pitagoras.springboot.demo.rent.dao;

import com.pitagoras.springboot.demo.rent.entity.Seed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface SeedRepository extends JpaRepository<Seed, Integer> {
    Optional<Seed> findByName(String name);

}
