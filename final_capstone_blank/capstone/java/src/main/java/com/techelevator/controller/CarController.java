package com.techelevator.controller;

import com.techelevator.dao.CarDao;
import com.techelevator.dao.JdbcCarDao;
import com.techelevator.model.Car;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class CarController {

    CarDao carDao;

    public CarController(CarDao carDao){
        this.carDao = carDao;
    }



    @RequestMapping(path = "/requestrepair", method = RequestMethod.POST)
    public void addCar(@RequestBody Car car){
        carDao.createCar(car);
    }

}
