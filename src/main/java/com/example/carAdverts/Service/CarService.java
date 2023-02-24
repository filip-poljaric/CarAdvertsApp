package com.example.carAdverts.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.carAdverts.ErrorHandler.CarNotFoundException;
import com.example.carAdverts.Model.Car;
import com.example.carAdverts.Repository.CarRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CarService {

    @Autowired
    private CarRepository repository;

    public Car addCar(Car car) {
        car.setCarId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(car);
    }

    public List<Car> findAllCars(String sortBy) {
        return repository.findAll(Sort.by(Sort.Direction.ASC, sortBy));
    }

    public Car getCarByCarId(String carId) throws CarNotFoundException {

        if (!repository.existsById(carId)) {
            throw new CarNotFoundException(" No car advert with given id was found.");
        }

        return repository.findById(carId).get();

    }

    public Car updateCar(String carId, Car carRequest) throws CarNotFoundException {

        if (!repository.existsById(carId)) {
            throw new CarNotFoundException(" No car advert with given id was found.");
        }

        Car existingCar = repository.findById(carId).get();
        existingCar.setTitle(carRequest.getTitle());
        existingCar.setFuelType(carRequest.getFuelType());
        existingCar.setPrice(carRequest.getPrice());
        existingCar.setIsNew(carRequest.getIsNew());
        existingCar.setMileage(carRequest.getMileage());
        existingCar.setFirstRegistration(carRequest.getFirstRegistration());
        return repository.save(existingCar);

    }

    public String deleteCar(String carId) throws CarNotFoundException {

        if (!repository.existsById(carId)) {
            throw new CarNotFoundException(" No car advert with given id was found.");
        }

        repository.deleteById(carId);
        return " Car with id: " + carId + " deleted from Adverts ";
    }

}
