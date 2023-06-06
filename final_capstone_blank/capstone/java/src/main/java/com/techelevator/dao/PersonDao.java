package com.techelevator.dao;

import com.techelevator.model.Person;

public interface PersonDao {

    void createPerson(Person person);

    Person getPersonById(int userId);
}
