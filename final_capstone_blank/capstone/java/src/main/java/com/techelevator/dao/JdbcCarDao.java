package com.techelevator.dao;

import com.techelevator.model.Car;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
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
        String sql = "INSERT INTO cars (make, model, year, color, description) VALUES (?,?,?,?,?);";
        jdbcTemplate.update(sql, car.getMake(), car.getModel(), car.getYear(), car.getColor(), car.getDescription());
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> allCars = new ArrayList<>();
        String sql = "SELECT car_id, make, model, year, color, description FROM cars";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            allCars.add(mapRowToCar(results));
        }
        return allCars;
    }

    @Override
    public Car getCarById(int carId) {
        Car car = new Car();
        String sql = "SELECT car_id, make, model, year, color, description FROM cars WHERE car_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, carId);
        while (results.next()){
            car = mapRowToCar(results);
        }
        return car;
    }

    public Car mapRowToCar(SqlRowSet sqlRowSet){
        Car car = new Car();
        car.setCarId(sqlRowSet.getInt("car_id"));
        car.setMake(sqlRowSet.getString("make"));
        car.setModel(sqlRowSet.getString("model"));
        car.setYear(sqlRowSet.getInt("year"));
        car.setColor(sqlRowSet.getString("color"));
        car.setDescription(sqlRowSet.getString("description"));
        return car;
    }
}
