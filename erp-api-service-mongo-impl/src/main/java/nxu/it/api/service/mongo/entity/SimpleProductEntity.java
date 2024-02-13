package nxu.it.api.service.mongo.entity;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class SimpleProductEntity {
    @BsonProperty("id")
    protected Integer id;
    protected String name;
    protected String quantityPerUnit;

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

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }
}
