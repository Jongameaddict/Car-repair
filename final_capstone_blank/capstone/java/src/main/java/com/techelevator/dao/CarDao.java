package com.techelevator.dao;

import com.techelevator.model.Car;

import java.util.List;

public interface CarDao {

    //create
    void createCar(Car car);

    //read
    List<Car> getAllCars();
    Car getCarById(int carId);


}
