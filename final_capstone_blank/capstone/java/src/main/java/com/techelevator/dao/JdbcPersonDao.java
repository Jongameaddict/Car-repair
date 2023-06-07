package com.techelevator.dao;

import com.techelevator.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcPersonDao implements PersonDao{

    private JdbcTemplate jdbcTemplate;
    public JdbcPersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createPerson(Person person) {
        String sql = "INSERT INTO person(user_id, firstname, lastname, username, email, phone) VALUES (?,?,?,?,?,?);";
        jdbcTemplate.update(sql, person.getUserId(), person.getFirstName(), person.getLastName(), person.getUsername(), person.getEmail(), person.getPhone());
    }

    @Override
    public Person getPersonById(int userId) {
        Person person = new Person();
        String sql = "SELECT user_id, firstname, lastname, username, email, phone FROM person WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()){
            person = mapRowToPerson(results);
        }
        return person;
    }

    public Person mapRowToPerson(SqlRowSet sqlRowSet){
        Person person = new Person();
        person.setUserId(sqlRowSet.getInt("user_id"));
        person.setFirstName(sqlRowSet.getString("firstname"));
        person.setLastName(sqlRowSet.getString("lastname"));
        person.setUsername(sqlRowSet.getString("username"));
        person.setEmail(sqlRowSet.getString("email"));
        person.setPhone(sqlRowSet.getInt("phone"));
        return person;
    }

}
