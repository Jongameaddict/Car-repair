package com.techelevator.controller;

import com.techelevator.dao.CarDao;
import com.techelevator.dao.JdbcCarDao;
import com.techelevator.model.Car;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class CarController {

    CarDao carDao;

    public CarController(CarDao carDao){
        this.carDao = carDao;
    }



    @RequestMapping(path = "/request-repair", method = RequestMethod.POST)
    public void addCar(@RequestBody Car car){
        carDao.createCar(car);
    }

    @RequestMapping (path = "/requests", method = RequestMethod.GET)
    public List<Car> getAllRepairRequests(){
        return carDao.getAllCars();
    }

    @RequestMapping(path = "/requests/{id}", method = RequestMethod.GET)
    public Car getCar(@PathVariable int carId){
        Car car = carDao.getCarById(carId);
        return car;
    }

    @RequestMapping(path = "update-repair/{id}", method = RequestMethod.PUT)
    public void updateRepair(@RequestBody Car car, @PathVariable int carId){
        carDao.updateRepairStatus(car, carId);
    }

    @RequestMapping(path = "update-repair/{id}", method = RequestMethod.PUT)
    public void updatePayment(@RequestBody Car car, @PathVariable int carId){
        carDao.updatePaymentStatus(car, carId);
    }
}
