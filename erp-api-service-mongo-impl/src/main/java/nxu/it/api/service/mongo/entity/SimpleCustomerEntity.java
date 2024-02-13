package nxu.it.api.service.mongo.entity;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class SimpleCustomerEntity {
    @BsonProperty("id")
    protected Integer id;
    protected String name;
    protected String contact;
    protected String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
