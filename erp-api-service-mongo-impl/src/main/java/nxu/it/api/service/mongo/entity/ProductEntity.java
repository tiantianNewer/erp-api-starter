package nxu.it.api.service.mongo.entity;

public class ProductEntity {
    protected Integer id;
    protected String brand;
    protected String name;
    protected String barCode;
    protected String quantityPerUnit;
    protected Float unitPrice;
    protected Long unitsInStock;
    protected Integer unitsSell;
    protected String photoUrl;

    protected CategoryEntity categoryEntity;

}
