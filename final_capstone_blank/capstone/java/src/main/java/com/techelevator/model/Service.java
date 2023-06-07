package com.techelevator.model;

import java.time.LocalTime;

public class Service {

    private int serviceId;
    private int car_Id;
    private int customerId;
    private int employeeId;
    private String repairStatus;
    private String paymentStatus;
    private LocalTime pickupTime;

    public Service(int serviceId, int car_Id, int customerId, int employeeId, String repairStatus, String paymentStatus, LocalTime pickupTime) {
        this.serviceId = serviceId;
        this.car_Id = car_Id;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.repairStatus = repairStatus;
        this.paymentStatus = paymentStatus;
        this.pickupTime = pickupTime;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getCar_Id() {
        return car_Id;
    }

    public void setCar_Id(int car_Id) {
        this.car_Id = car_Id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(String repairStatus) {
        this.repairStatus = repairStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalTime getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(LocalTime pickupTime) {
        this.pickupTime = pickupTime;
    }
}
