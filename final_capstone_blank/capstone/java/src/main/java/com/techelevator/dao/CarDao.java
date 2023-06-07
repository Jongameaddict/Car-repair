package com.techelevator.dao;

import com.techelevator.model.Car;

import java.util.List;

public interface CarDao {

    //create
    void createCar(Car car);

    //read
    List<Car> getAllCars();
    Car getCarById(int carId);

    //update
    void updateRepairStatus(Car car, int carId);
    void updatePaymentStatus(Car car, int carId);
}
