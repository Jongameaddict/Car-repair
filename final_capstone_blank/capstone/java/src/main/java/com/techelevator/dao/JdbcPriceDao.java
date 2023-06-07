package com.techelevator.dao;
//talks with database, 'GET * FROM' etc

import com.techelevator.model.Price;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPriceDao implements PriceDao {
	private JdbcTemplate template;
	
	public JdbcPriceDao(JdbcTemplate jdbcTemplate) {
		this.template = jdbcTemplate;
	}
	
	@Override
	public List<Price> getPrices() {
		String sqlGetAllPrices = "SELECT * FROM repair_types";
		List<Price> priceList = new ArrayList<Price>();
		SqlRowSet rowSet = template.queryForRowSet(sqlGetAllPrices);
		
		while (rowSet.next()) {
			Price newPrice = new Price();
			
			newPrice.setRepairId(rowSet.getInt("repair_id"));
			newPrice.setRepairType(rowSet.getString("repair_type"));
			newPrice.setPrice(rowSet.getInt("price"));
			
			priceList.add(newPrice);
		}
		return priceList;
	}
	
	@Override
	public Price getPrice(int id) {
		// TODO Auto-generated method stub
		String getPriceSQL = "SELECT * FROM repair_types where id = ?";
		SqlRowSet result = template.queryForRowSet(getPriceSQL, id);
		Price price = null;
		
		if (result.next()) {
			price.setRepairId(result.getInt("repair_id"));
			price.setRepairType(result.getString("repair_type"));
			price.setPrice(result.getInt("price"));
		}
		return price;
	}
}