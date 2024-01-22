package nxu.it.api.service.pg.mapper;


import nxu.it.api.service.pg.entity.ProductEntity;
import nxu.it.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface ProductMapper {
    Product toProduct(ProductEntity productEntity);

    List<Product> toProductList(List<ProductEntity> productEntityList);
}
