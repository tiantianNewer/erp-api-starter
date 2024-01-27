package nxu.it.api.service.pg.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Metamodel;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_LOWER_CASE, metamodel = @Metamodel)
public class OrderDetailEntity {
    protected Float unitPrice;
    protected Float actualUnitPrice;
    protected Integer quantity;
    protected Float discount;
    protected Double totalPrice;
    protected Integer productId;
    protected String productName;
    protected String productQuantityPerUnit;

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Float getActualUnitPrice() {
        return actualUnitPrice;
    }

    public void setActualUnitPrice(Float actualUnitPrice) {
        this.actualUnitPrice = actualUnitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductQuantityPerUnit() {
        return productQuantityPerUnit;
    }

    public void setProductQuantityPerUnit(String productQuantityPerUnit) {
        this.productQuantityPerUnit = productQuantityPerUnit;
    }
}
