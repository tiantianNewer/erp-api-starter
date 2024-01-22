package nxu.it.api.service.pg.mapper;

import nxu.it.api.service.pg.entity.OrderDetailEntity;
import nxu.it.api.service.pg.entity.OrderEntity;
import nxu.it.model.Order;
import nxu.it.model.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface OrderMapper {
    Order toOrder(OrderEntity orderEntity);
    OrderDetail toOrderDetail(OrderDetailEntity orderDetailEntity);

    List<Order> toOrderList(List<OrderEntity> orderEntityList);
    List<OrderDetail> toOrderDetailList(List<OrderDetailEntity> orderDetailEntityList);
}
