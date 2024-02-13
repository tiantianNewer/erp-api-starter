package nxu.it.api.service.mongo.entity;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class SimpleShipperEntity {
    @BsonProperty("id")
    protected Integer id;
    protected String name;

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
}
