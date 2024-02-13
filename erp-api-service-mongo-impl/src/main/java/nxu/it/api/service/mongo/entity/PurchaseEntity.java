package nxu.it.api.service.mongo.entity;

import org.bson.types.Decimal128;

public class PurchaseEntity {
    protected Integer purchaseUnitPrice;
    protected Integer amount;
    protected SimpleProductEntity product;
    protected SimpleSupplierEntity supplier;

    public Integer getPurchaseUnitPrice() {
        return purchaseUnitPrice;
    }

    public void setPurchaseUnitPrice(Integer purchaseUnitPrice) {
        this.purchaseUnitPrice = purchaseUnitPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public SimpleProductEntity getProduct() {
        return product;
    }

    public void setProduct(SimpleProductEntity product) {
        this.product = product;
    }

    public SimpleSupplierEntity getSupplier() {
        return supplier;
    }

    public void setSupplier(SimpleSupplierEntity supplier) {
        this.supplier = supplier;
    }
}
