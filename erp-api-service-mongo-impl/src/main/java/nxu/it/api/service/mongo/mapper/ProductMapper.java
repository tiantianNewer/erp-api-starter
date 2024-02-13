package nxu.it.api.service.mongo.mapper;

import nxu.it.api.service.mongo.entity.*;
import nxu.it.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "product.id", target = "id"),
            @Mapping(source = "product.name", target = "name"),
            @Mapping(source = "product.quantityPerUnit", target = "quantityPerUnit"),
            @Mapping(source = "amount", target = "purchaseAmount"),
            @Mapping(source = "supplier.id", target = "supplierId"),
            @Mapping(source = "supplier.name", target = "supplierName")
    })
    Product purchaseToProduct(PurchaseEntity purchaseEntity);
    default Product toProduct(ProductEntity productEntity) {
        if (productEntity == null) {
            return null;
        }
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setBrand(productEntity.getBrand());
        product.setName(productEntity.getName());
        product.setBarCode(productEntity.getBarCode());
        product.setQuantityPerUnit(productEntity.getQuantityPerUnit());
        product.setUnitPrice(productEntity.getUnitPrice().floatValue());
        product.setUnitsInStock(productEntity.getUnitsInStock());
        product.setUnitsSell(productEntity.getUnitsSell());
        product.setPhoto(productEntity.getPhoto());
        List<SimpleSupplierEntity> suppliers = productEntity.getSuppliers();
        if (suppliers != null) {
            product.setSupplierId(suppliers.get(0).getId().longValue());
            product.setSupplierName(suppliers.get(0).getName());
            suppliers.remove(0);
        }
        CategoriesOfProduct categories = productEntity.getCategory();
        if (categories != null) {
            String categoryId1 = categories.getLevel1().getId().toString();
            if (categoryId1.length()%2 == 0) {
                product.setCategoryId1(categoryId1);
                product.setCategoryId2(categories.getLevel2().getId().toString());
                product.setCategoryId3(categories.getLevel3().getId().toString());
            } else {
                product.setCategoryId1("0" + categoryId1);
                product.setCategoryId2("0" + categories.getLevel2().getId().toString());
                product.setCategoryId3("0" + categories.getLevel3().getId().toString());
            }
            product.setCategoryName1(categories.getLevel1().getName());
            product.setCategoryName2(categories.getLevel2().getName());
            product.setCategoryName3(categories.getLevel3().getName());
        }
        return product;
    }
    List<Product> purchasesToProductList(List<PurchaseEntity> purchaseEntityList);
    default List<Product> toProductList(List<ProductEntity> productEntityList) {
        if (productEntityList == null) {
            return null;
        } else {
            List<Product> list = new ArrayList();
            Iterator productEntityIterator = productEntityList.iterator();
            while(productEntityIterator.hasNext()) {
                ProductEntity productEntity = (ProductEntity)productEntityIterator.next();
                if (productEntity.getSuppliers() == null) { //映射不需要供应商信息时
                    list.add(this.toProduct(productEntity));
                } else { //映射需要供应商信息时
                    while (!productEntity.getSuppliers().isEmpty()) {
                        list.add(this.toProduct(productEntity));
                    }
                }
            }
            return list;
        }
    }
}
