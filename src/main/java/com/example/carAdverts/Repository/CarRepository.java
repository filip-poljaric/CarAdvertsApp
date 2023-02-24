package com.example.carAdverts.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.carAdverts.Model.Car;

public interface CarRepository extends MongoRepository<Car, String> {
}
