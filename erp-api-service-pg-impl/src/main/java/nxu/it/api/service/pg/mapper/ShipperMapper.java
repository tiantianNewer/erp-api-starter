package nxu.it.api.service.pg.mapper;

import nxu.it.api.service.pg.entity.ShipperEntity;
import nxu.it.model.Shipper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface ShipperMapper {
    Shipper toShipper(ShipperEntity shipperEntity);
    List<Shipper> toShipperList(List<ShipperEntity> shipperEntityList);
}
