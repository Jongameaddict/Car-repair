package com.techelevator.dao;

import com.techelevator.model.Service;

import java.util.List;

public interface ServiceDao {

    void createServiceRequest(Service service);

    List<Service> getAllServices();
    Service getServiceById(int serviceId);

    void updateTransfer(Service service, int serviceId);
}
