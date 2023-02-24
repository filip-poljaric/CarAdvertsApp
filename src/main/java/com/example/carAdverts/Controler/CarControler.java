package com.example.carAdverts.Controler;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.carAdverts.ErrorHandler.CarNotFoundException;
import com.example.carAdverts.Model.Car;

import com.example.carAdverts.Service.CarService;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/car/adverts")
public class CarControler {

    @Autowired
    private CarService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car createCar(@RequestBody @Valid Car car) {
        return service.addCar(car);
    }

    @GetMapping
    public List<Car> getaCars(@RequestParam("sortby") Optional<String> sortby) {
        String sorting = sortby.orElse("carId");
        return service.findAllCars(sorting);
    }

    @GetMapping("/{carId}")
    public Car getCar(@PathVariable String carId) throws CarNotFoundException {
        return service.getCarByCarId(carId);
    }

    @PutMapping("/{carId}")
    public Car modifyCar(@PathVariable String carId, @RequestBody @Valid Car car) throws CarNotFoundException {
        return service.updateCar(carId, car);
    }

    @DeleteMapping("/{carId}")
    public String deleteCar(@PathVariable String carId) throws CarNotFoundException {
        return service.deleteCar(carId);
    }
}
