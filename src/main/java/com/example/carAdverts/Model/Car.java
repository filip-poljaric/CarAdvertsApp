package com.example.carAdverts.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cars")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Car {
    @Id
    private String carId;

    @NotEmpty(message = "title is required")
    private String title;

    @NotEmpty(message = "fulel type is required")
    private String fuelType;

    @Min(value = 0, message = "Price cannot be negative")
    @NotNull(message = "price is required.")
    private Integer price;

    @NotNull(message = "isNew is required")
    private Boolean isNew;

    @Min(value = 0, message = "Mileage cannot be negative")
    @NotNull(message = "Mileage is required.")
    private Integer mileage;

    @NotNull(message = "firstRegistration is required")
    private Date firstRegistration;

}
