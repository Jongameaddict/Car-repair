package com.techelevator.dao;
//name the methods in jdbcpricedao

import com.techelevator.model.Price;
import java.util.List;

public interface PriceDao {
	Price getPrice(int id);
	List<Price> getPrices();
}