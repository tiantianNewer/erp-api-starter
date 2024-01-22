package nxu.it.api.service.pg.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Metamodel;
import org.seasar.doma.jdbc.entity.NamingType;

import java.time.LocalDateTime;

@Entity(naming = NamingType.SNAKE_LOWER_CASE, metamodel = @Metamodel)
public class OrderEntity {
    @Id
    protected String id;
    protected Integer customer_id;
    protected String customer_name;
    protected String customer_contact;
    protected String customer_phone;
    protected String employee_id;
    protected String employee_name;
    protected String employee_phone;
    protected LocalDateTime order_date;
    protected LocalDateTime ship_date;
    protected LocalDateTime arrival_date;
    protected Float freight;
    protected Integer shipper_id;
    protected String shipper_name;
    protected String shipper_phone;
    protected String ship_address;
    protected String ship_province;
    protected String ship_city;
    protected String ship_region;
    protected String contact;
//    protected List<OrderDetail> detail_list;
//    protected Double total_price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_contact() {
        return customer_contact;
    }

    public void setCustomer_contact(String customer_contact) {
        this.customer_contact = customer_contact;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_phone() {
        return employee_phone;
    }

    public void setEmployee_phone(String employee_phone) {
        this.employee_phone = employee_phone;
    }

    public LocalDateTime getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDateTime order_date) {
        this.order_date = order_date;
    }

    public LocalDateTime getShip_date() {
        return ship_date;
    }

    public void setShip_date(LocalDateTime ship_date) {
        this.ship_date = ship_date;
    }

    public LocalDateTime getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(LocalDateTime arrival_date) {
        this.arrival_date = arrival_date;
    }

    public Float getFreight() {
        return freight;
    }

    public void setFreight(Float freight) {
        this.freight = freight;
    }

    public Integer getShipper_id() {
        return shipper_id;
    }

    public void setShipper_id(Integer shipper_id) {
        this.shipper_id = shipper_id;
    }

    public String getShipper_name() {
        return shipper_name;
    }

    public void setShipper_name(String shipper_name) {
        this.shipper_name = shipper_name;
    }

    public String getShipper_phone() {
        return shipper_phone;
    }

    public void setShipper_phone(String shipper_phone) {
        this.shipper_phone = shipper_phone;
    }

    public String getShip_address() {
        return ship_address;
    }

    public void setShip_address(String ship_address) {
        this.ship_address = ship_address;
    }

    public String getShip_province() {
        return ship_province;
    }

    public void setShip_province(String ship_province) {
        this.ship_province = ship_province;
    }

    public String getShip_city() {
        return ship_city;
    }

    public void setShip_city(String ship_city) {
        this.ship_city = ship_city;
    }

    public String getShip_region() {
        return ship_region;
    }

    public void setShip_region(String ship_region) {
        this.ship_region = ship_region;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
