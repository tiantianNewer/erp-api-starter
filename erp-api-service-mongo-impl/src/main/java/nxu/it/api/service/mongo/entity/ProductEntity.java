package nxu.it.api.service.mongo.entity;

import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonRepresentation;

public class ProductEntity {
    protected Integer id;
    protected String brand;
    protected String name;
    protected String barCode;
    protected String quantityPerUnit;
    @BsonRepresentation(BsonType.DECIMAL128)
    protected Double unitPrice;
    protected Long unitsInStock;
    protected Integer unitsSell;
    protected String photoUrl;

    protected SupplierEntity supplierEntity;

    protected CategoryEntity level1;
    protected CategoryEntity level2;
    protected CategoryEntity level3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(Long unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public Integer getUnitsSell() {
        return unitsSell;
    }

    public void setUnitsSell(Integer unitsSell) {
        this.unitsSell = unitsSell;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public SupplierEntity getSupplierEntity() {
        return supplierEntity;
    }

    public void setSupplierEntity(SupplierEntity supplierEntity) {
        this.supplierEntity = supplierEntity;
    }

    public CategoryEntity getLevel1() {
        return level1;
    }

    public void setLevel1(CategoryEntity level1) {
        this.level1 = level1;
    }

    public CategoryEntity getLevel2() {
        return level2;
    }

    public void setLevel2(CategoryEntity level2) {
        this.level2 = level2;
    }

    public CategoryEntity getLevel3() {
        return level3;
    }

    public void setLevel3(CategoryEntity level3) {
        this.level3 = level3;
    }
}
