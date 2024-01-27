package nxu.it.api.service.pg.mapper;


import nxu.it.api.service.pg.entity.ProductEntity;
import nxu.it.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface ProductMapper {

    @Mapping(source = "quantity_per_unit", target = "quantityPerUnit")
    Product toProduct(ProductEntity productEntity);

    List<Product> toProductList(List<ProductEntity> productEntityList);
}
