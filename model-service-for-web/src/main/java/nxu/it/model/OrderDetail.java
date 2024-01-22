package nxu.it.model;

public class OrderDetail {
    protected Float unit_price;
    protected Float actual_unit_price;
    protected Integer quantity;
    protected Float discount;
    protected Double total_price;
    protected Integer product_id;
    protected String product_name;
    protected String product_quantity_per_unit;

    public OrderDetail() {
    }

    public Float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Float unit_price) {
        this.unit_price = unit_price;
    }

    public Float getActual_unit_price() {
        return actual_unit_price;
    }

    public void setActual_unit_price(Float actual_unit_price) {
        this.actual_unit_price = actual_unit_price;
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

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_quantity_per_unit() {
        return product_quantity_per_unit;
    }

    public void setProduct_quantity_per_unit(String product_quantity_per_unit) {
        this.product_quantity_per_unit = product_quantity_per_unit;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "unit_price=" + unit_price +
                ", actual_unit_price=" + actual_unit_price +
                ", quantity=" + quantity +
                ", discount=" + discount +
                ", total_price=" + total_price +
                ", product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_quantity_per_unit='" + product_quantity_per_unit + '\'' +
                '}';
    }
}
