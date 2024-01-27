package nxu.it.api.service.pg.mapper;

import nxu.it.api.service.pg.entity.OrderDetailEntity;
import nxu.it.api.service.pg.entity.OrderEntity;
import nxu.it.model.Order;
import nxu.it.model.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface OrderMapper {
    //顺序调换过来就不行了
    OrderDetail toOrderDetail(OrderDetailEntity orderDetailEntity);
    Order toOrder(OrderEntity orderEntity);

    List<OrderDetail> toOrderDetailList(List<OrderDetailEntity> orderDetailEntityList);
    List<Order> toOrderList(List<OrderEntity> orderEntityList);
}
