package nxu.it.api.service.mongo.mapper;

import nxu.it.api.service.mongo.entity.OrderDetailEntity;
import nxu.it.api.service.mongo.entity.OrdersEntity;
import nxu.it.api.service.mongo.entity.SimpleProductEntity;
import nxu.it.model.Order;
import nxu.it.model.OrderDetail;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface OrderMapper {
    private Integer orderDetailEntityProductId(OrderDetailEntity orderDetailEntity) {
        if (orderDetailEntity == null) {
            return null;
        } else {
            SimpleProductEntity product = orderDetailEntity.getProduct();
            if (product == null) {
                return null;
            } else {
                Integer id = product.getId();
                return id == null ? null : id;
            }
        }
    }

    private String orderDetailEntityProductName(OrderDetailEntity orderDetailEntity) {
        if (orderDetailEntity == null) {
            return null;
        } else {
            SimpleProductEntity product = orderDetailEntity.getProduct();
            if (product == null) {
                return null;
            } else {
                String name = product.getName();
                return name == null ? null : name;
            }
        }
    }

    private String orderDetailEntityProductQuantityPerUnit(OrderDetailEntity orderDetailEntity) {
        if (orderDetailEntity == null) {
            return null;
        } else {
            SimpleProductEntity product = orderDetailEntity.getProduct();
            if (product == null) {
                return null;
            } else {
                String quantityPerUnit = product.getQuantityPerUnit();
                return quantityPerUnit == null ? null : quantityPerUnit;
            }
        }
    }
    /*@Mappings({
            @Mapping(source = "product.id", target = "productId"),
            @Mapping(source = "product.name", target = "productName"),
            @Mapping(source = "product.quantityPerUnit", target = "productQuantityPerUnit")
    })*/
    default OrderDetail toOrderDetail(OrderDetailEntity orderDetailEntity) {
        if (orderDetailEntity == null) {
            return null;
        } else {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProductId(this.orderDetailEntityProductId(orderDetailEntity));
            orderDetail.setProductName(this.orderDetailEntityProductName(orderDetailEntity));
            orderDetail.setProductQuantityPerUnit(this.orderDetailEntityProductQuantityPerUnit(orderDetailEntity));
            if (orderDetailEntity.getUnitPrice() != null) {
                orderDetail.setUnitPrice(orderDetailEntity.getUnitPrice().floatValue());
            }

            Double actualUnitPrice = orderDetailEntity.getActualUnitPrice();
            if (actualUnitPrice != null) {
                orderDetail.setActualUnitPrice(actualUnitPrice.floatValue());
            }

            Integer quantity = orderDetailEntity.getQuantity();
            orderDetail.setQuantity(quantity);
            if (orderDetailEntity.getDiscount() != null) {
                orderDetail.setDiscount(orderDetailEntity.getDiscount().floatValue());
            }

            if (actualUnitPrice != null && quantity != null) {
                orderDetail.setTotalPrice(quantity*actualUnitPrice);
            }
            return orderDetail;
        }
    }
    @Named("toOrderDetailList")
    List<OrderDetail> toOrderDetailList(List<OrderDetailEntity> orderDetailEntityList);
    @Mappings({
            @Mapping(source = "customer.id", target = "customerId"),
            @Mapping(source = "customer.name", target = "customerName"),
            @Mapping(source = "customer.contact", target = "customerContact"),
            @Mapping(source = "customer.phone", target = "customerPhone"),
            @Mapping(source = "employee.id", target = "employeeId"),
            @Mapping(source = "employee.name", target = "employeeName"),
            @Mapping(source = "employee.phone", target = "employeePhone"),
            @Mapping(source = "shipInfo.freight", target = "freight"),
            @Mapping(source = "shipInfo.shipper.id", target = "shipperId"),
            @Mapping(source = "shipInfo.shipper.name", target = "shipperName"),
            @Mapping(source = "shipInfo.phone", target = "shipperPhone"),
            @Mapping(source = "shipInfo.shipAddress", target = "shipAddress"),
            @Mapping(source = "shipInfo.shipProvince", target = "shipProvince"),
            @Mapping(source = "shipInfo.shipCity", target = "shipCity"),
            @Mapping(source = "shipInfo.shipRegion", target = "shipRegion"),
            @Mapping(source = "shipInfo.contact", target = "contact"),
            @Mapping(source = "details", target = "detailList", qualifiedByName = "toOrderDetailList"),
            //在Impl中写totalPrice映射
    })
    Order toOrder(OrdersEntity ordersEntity);
    List<Order> toOrderList(List<OrdersEntity> ordersEntityList);
}
