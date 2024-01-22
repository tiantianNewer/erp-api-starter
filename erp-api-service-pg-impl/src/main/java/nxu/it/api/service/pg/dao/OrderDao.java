package nxu.it.api.service.pg.dao;

import nxu.it.api.service.pg.entity.OrderDetailEntity;
import nxu.it.api.service.pg.entity.OrderEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import java.time.LocalDateTime;
import java.util.List;

@Dao
public interface OrderDao {
    @Select
    OrderEntity findByOrderId(String orderId);
    @Select
    List<OrderDetailEntity> findDetailByOrderId(String orderId);
    @Select
    List<OrderEntity> page(LocalDateTime startDate, LocalDateTime endDate, String customerName, String shipperName, String shipProvince, String shipCity, String shipRegion);
    @Select
    List<OrderEntity> pageByEmployeeId(String employeeId, LocalDateTime startDate, LocalDateTime endDate, String customerName, String shipperName, String shipProvince, String shipCity, String shipRegion);
    @Select
    List<OrderEntity> pageByCustomerId(Integer customerId, LocalDateTime startDate, LocalDateTime endDate, String customerName, String shipperName, String shipProvince, String shipCity, String shipRegion);
    @Select
    List<OrderEntity> pageByShipperId(Integer shipperId, LocalDateTime startDate, LocalDateTime endDate, String customerName, String shipperName, String shipProvince, String shipCity, String shipRegion);
}
