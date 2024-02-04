package nxu.it.api.service.mongo.entity;

import org.bson.types.Decimal128;

public class ProductEntity {
    protected Integer id;
    protected String brand;
    protected String name;
    protected String barCode;
    protected String quantityPerUnit;
    protected Decimal128 unitPrice;
    protected Long unitsInStock;
    protected Integer unitsSell;
    protected String photo;

    protected SimpleSupplierEntity simpleSupplierEntity;

    protected SimpleCategoryEntity level1;
    protected SimpleCategoryEntity level2;
    protected SimpleCategoryEntity level3;

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

    public Decimal128 getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Decimal128 unitPrice) {
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public SimpleSupplierEntity getSimpleSupplierEntity() {
        return simpleSupplierEntity;
    }

    public void setSimpleSupplierEntity(SimpleSupplierEntity simpleSupplierEntity) {
        this.simpleSupplierEntity = simpleSupplierEntity;
    }

    public SimpleCategoryEntity getLevel1() {
        return level1;
    }

    public void setLevel1(SimpleCategoryEntity level1) {
        this.level1 = level1;
    }

    public SimpleCategoryEntity getLevel2() {
        return level2;
    }

    public void setLevel2(SimpleCategoryEntity level2) {
        this.level2 = level2;
    }

    public SimpleCategoryEntity getLevel3() {
        return level3;
    }

    public void setLevel3(SimpleCategoryEntity level3) {
        this.level3 = level3;
    }
}
