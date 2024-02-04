package nxu.it.api.service.mongo.mapper;

import nxu.it.api.service.mongo.entity.ProductEntity;
import nxu.it.model.Product;
import org.bson.types.Decimal128;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface ProductMapper {
    public interface Decimal128Mapper {
        Float mapToFloat(Decimal128 decimal128);
    }
    @Mappings({
//            @Mapping(source = "unitPrice.floatValue()", target = "unitPrice"),
            @Mapping(source = "simpleSupplierEntity.id", target = "supplierId"),
            @Mapping(source = "simpleSupplierEntity.name", target = "supplierName"),
            @Mapping(source = "level1.id", target = "categoryId1"),
            @Mapping(source = "level1.name", target = "categoryName1"),
            @Mapping(source = "level2.id", target = "categoryId2"),
            @Mapping(source = "level2.name", target = "categoryName2"),
            @Mapping(source = "level3.id", target = "categoryId3"),
            @Mapping(source = "level3.name", target = "categoryName3")
    })
    Product toProduct(ProductEntity productEntity);

    List<Product> toProductList(List<ProductEntity> productEntityList);
}
