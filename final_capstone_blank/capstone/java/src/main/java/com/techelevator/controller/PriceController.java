package com.techelevator.controller;
//getmapping and postmapping for api work
//when user selects a service, select an endpoint from here
//front end can handle the math for prices, then have an endpoint for adding all prices

import com.techelevator.dao.PriceDao;
import com.techelevator.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class PriceController {

	PriceDao priceDao;

	public PriceController(PriceDao priceDao){
		this.priceDao = priceDao;
	}


	//If our user selects services, we need to read from the database to create service objects, serialize the
	// service objects into JSON, get the prices of each selected service using this, then add the prices together
	
	@GetMapping(path="/allPrices")
	public List<Price> getAllPrices() {
		List<Price> allPrices = priceDao.getPrices();
		return allPrices;
	}
	
	@GetMapping(path="/price/{id}")
	public Price returnPriceById(@PathVariable int id) {
		Price price = priceDao.getPrice(id);
		return price;
	}
}