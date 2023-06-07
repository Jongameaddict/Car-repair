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
	
	public JdbcPriceDao(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Price> getPrices() {
		String sqlGetAllPrices = "SELECT * FROM prices";
		List<Price> priceList = new ArrayList<Price>();
		SqlRowSet rowSet = template.queryForRowSet(sqlGetAllPrices);
		
		while (rowSet.next()) {
			int id = rowSet.getInt("id");
			String service = rowSet.getString("service");
			Price price = new Price(id, service);
			priceList.add(price);
		}
		return priceList;
	}
	
	@Override
	public Price getPrice(int id) {
		// TODO Auto-generated method stub
		String getPriceSQL = "SELECT * FROM price where id = ?";
		SqlRowSet result = template.queryForRowSet(getPriceSQL, id);
		Price price = null;
		
		if (result.next()) {
			int id2 = result.getInt("id");
			String service = result.getString("service");

			price = new Price(id2, service);
		}
		return price;
	}
}