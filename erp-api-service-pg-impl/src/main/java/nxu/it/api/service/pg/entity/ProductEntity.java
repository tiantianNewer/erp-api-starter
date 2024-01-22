package nxu.it.api.service.pg.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Metamodel;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_LOWER_CASE, metamodel = @Metamodel)
public class ProductEntity {
    protected Integer id;
    protected String brand;
    protected String name;
    protected String bar_code;
    protected String quantity_per_unit;
    protected Float unit_price;
    protected Long units_in_stock;
    protected Integer units_sell;
    protected String photo_url;
    protected Integer purchase_unit_price;
    protected Integer purchase_amount;
    protected Long supplier_id;
    protected String supplier_name;
    protected String category_id1;
    protected String category_name1;
    protected String category_id2;
    protected String category_name2;
    protected String category_id3;
    protected String category_name3;

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

    public String getBar_code() {
        return bar_code;
    }

    public void setBar_code(String bar_code) {
        this.bar_code = bar_code;
    }

    public String getQuantity_per_unit() {
        return quantity_per_unit;
    }

    public void setQuantity_per_unit(String quantity_per_unit) {
        this.quantity_per_unit = quantity_per_unit;
    }

    public Float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Float unit_price) {
        this.unit_price = unit_price;
    }

    public Long getUnits_in_stock() {
        return units_in_stock;
    }

    public void setUnits_in_stock(Long units_in_stock) {
        this.units_in_stock = units_in_stock;
    }

    public Integer getUnits_sell() {
        return units_sell;
    }

    public void setUnits_sell(Integer units_sell) {
        this.units_sell = units_sell;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public Integer getPurchase_unit_price() {
        return purchase_unit_price;
    }

    public void setPurchase_unit_price(Integer purchase_unit_price) {
        this.purchase_unit_price = purchase_unit_price;
    }

    public Integer getPurchase_amount() {
        return purchase_amount;
    }

    public void setPurchase_amount(Integer purchase_amount) {
        this.purchase_amount = purchase_amount;
    }

    public Long getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(Long supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getCategory_id1() {
        return category_id1;
    }

    public void setCategory_id1(String category_id1) {
        this.category_id1 = category_id1;
    }

    public String getCategory_name1() {
        return category_name1;
    }

    public void setCategory_name1(String category_name1) {
        this.category_name1 = category_name1;
    }

    public String getCategory_id2() {
        return category_id2;
    }

    public void setCategory_id2(String category_id2) {
        this.category_id2 = category_id2;
    }

    public String getCategory_name2() {
        return category_name2;
    }

    public void setCategory_name2(String category_name2) {
        this.category_name2 = category_name2;
    }

    public String getCategory_id3() {
        return category_id3;
    }

    public void setCategory_id3(String category_id3) {
        this.category_id3 = category_id3;
    }

    public String getCategory_name3() {
        return category_name3;
    }

    public void setCategory_name3(String category_name3) {
        this.category_name3 = category_name3;
    }
}
