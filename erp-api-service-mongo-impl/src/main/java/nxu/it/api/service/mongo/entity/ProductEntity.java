package nxu.it.api.service.mongo.entity;

import org.bson.types.Decimal128;

import java.util.List;

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

    protected List<SimpleSupplierEntity> suppliers;

    protected CategoriesOfProduct category;

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

    public List<SimpleSupplierEntity> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SimpleSupplierEntity> suppliers) {
        this.suppliers = suppliers;
    }

    public CategoriesOfProduct getCategory() {
        return category;
    }

    public void setCategory(CategoriesOfProduct category) {
        this.category = category;
    }
}
