package com.example.carAdverts.ErrorHandler;

public class CarNotFoundException extends Exception {
    public CarNotFoundException(String message) {
        super(message);
    }
}
