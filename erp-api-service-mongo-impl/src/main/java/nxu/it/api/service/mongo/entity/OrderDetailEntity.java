package nxu.it.api.service.mongo.entity;

public class OrderDetailEntity {
    protected Double unitPrice;
    protected Double actualUnitPrice;
    protected Integer quantity;
    protected Double discount;
    protected SimpleProductEntity product;

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getActualUnitPrice() {
        return actualUnitPrice;
    }

    public void setActualUnitPrice(Double actualUnitPrice) {
        this.actualUnitPrice = actualUnitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
    public SimpleProductEntity getProduct() {
        return product;
    }

    public void setProduct(SimpleProductEntity product) {
        this.product = product;
    }
}
