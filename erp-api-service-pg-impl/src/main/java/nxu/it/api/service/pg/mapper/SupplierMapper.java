package nxu.it.api.service.pg.mapper;

import nxu.it.api.service.pg.entity.SupplierEntity;
import nxu.it.model.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface SupplierMapper {
    Supplier toSupplier(SupplierEntity supplierEntity);
    List<Supplier> toSupplierList(List<SupplierEntity> supplierEntityList);
}
