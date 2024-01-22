package nxu.it.model;

import nxu.it.api.common.param.PageQueryParam;

public class ProductPageQueryParam extends PageQueryParam {
    String name;
    String brand;
    String categoryId;
    Float minPrice;
    Float maxPrice;
    Boolean haveProduct;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Float minPrice) {
        this.minPrice = minPrice;
    }

    public Float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Boolean getHaveProduct() {
        return haveProduct;
    }

    public void setHaveProduct(Boolean haveProduct) {
        this.haveProduct = haveProduct;
    }
}
