package nxu.it.api.service.mongo.entity;

import java.time.LocalDateTime;
import java.util.List;

public class OrdersEntity {
    protected String id;
    SimpleCustomerEntity customer;
    SimpleEmployeeEntity employee;
    protected LocalDateTime orderDate;
    protected LocalDateTime shipDate;
    protected LocalDateTime arrivalDate;
    protected ShipInfoOfOrder shipInfo;
    protected List<OrderDetailEntity> details;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SimpleCustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(SimpleCustomerEntity customer) {
        this.customer = customer;
    }

    public SimpleEmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(SimpleEmployeeEntity employee) {
        this.employee = employee;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getShipDate() {
        return shipDate;
    }

    public void setShipDate(LocalDateTime shipDate) {
        this.shipDate = shipDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public ShipInfoOfOrder getShipInfo() {
        return shipInfo;
    }

    public void setShipInfo(ShipInfoOfOrder shipInfo) {
        this.shipInfo = shipInfo;
    }

    public List<OrderDetailEntity> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetailEntity> details) {
        this.details = details;
    }

}
