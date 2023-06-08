package com.techelevator.dao;

import com.techelevator.model.Car;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCarDao implements CarDao{

    private JdbcTemplate jdbcTemplate;
    public JdbcCarDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createCar(Car car) {
        String incomplete = "incomplete";
        String sql = "INSERT INTO cars (make, model, year, color, description, repair_status, payment_status) VALUES (?,?,?,?,?,?,?);";
        jdbcTemplate.update(sql, car.getMake(), car.getModel(), car.getYear(), car.getColor(), car.getDescription(), incomplete, incomplete);
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> allCars = new ArrayList<>();
        String sql = "SELECT car_id, make, model, year, color, description, repair_status, payment_status FROM cars";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            allCars.add(mapRowToCar(results));
        }
        return allCars;
    }

    @Override
    public Car getCarById(int carId) {
        Car car = new Car();
        String sql = "SELECT car_id, make, model, year, color, description, repair_status, payment_status FROM cars WHERE car_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, carId);
        while (results.next()){
            car = mapRowToCar(results);
        }
        return car;
    }

    @Override
    public void updateRepairStatus(Car car, int carId) {
        String sql = "UPDATE cars SET repair_status = 'completed' WHERE car_id = ?";
        jdbcTemplate.update(sql,carId);
    }

    @Override
    public void updatePaymentStatus(Car car, int carId) {
        String sql = "UPDATE cars SET payment_status = 'completed' WHERE car_id = ?";
        jdbcTemplate.update(sql, car.getCarId());
    }


    public Car mapRowToCar(SqlRowSet sqlRowSet){
        Car car = new Car();
        car.setCarId(sqlRowSet.getInt("car_id"));
        car.setMake(sqlRowSet.getString("make"));
        car.setModel(sqlRowSet.getString("model"));
        car.setYear(sqlRowSet.getInt("year"));
        car.setColor(sqlRowSet.getString("color"));
        car.setDescription(sqlRowSet.getString("description"));
        car.setRepairStatus(sqlRowSet.getString("repair_status"));
        car.setPaymentStatus(sqlRowSet.getString("payment_status"));
        return car;
    }
}
