package nxu.it.api.service.mongo.entity;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class SimpleEmployeeEntity {
    @BsonProperty("id")
    protected String id;
    protected String name;
    protected String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
