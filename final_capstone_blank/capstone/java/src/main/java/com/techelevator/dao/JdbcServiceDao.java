package com.techelevator.dao;

import com.techelevator.model.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcServiceDao implements ServiceDao{

    private JdbcTemplate jdbcTemplate;
    public JdbcServiceDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createServiceRequest(Service service) {

    }

    @Override
    public List<Service> getAllServices() {
        return null;
    }

    @Override
    public Service getServiceById(int serviceId) {
        return null;
    }

    @Override
    public void updateTransfer(Service service, int serviceId) {

    }


}
