package nxu.it.service;

import nxu.it.model.Order;
import nxu.it.api.common.result.Pageable;
import nxu.it.model.OrderPageQueryParam;

import java.util.Optional;

public interface OrderService {

    /**
     * 根据订单编号获得订单信息
     *
     * @param id 订单编号
     * @return 指定订单的一般信息及详细信息
     */
    Optional<Order> findByOrderId(String id);

    /**
     * 根据startDate 起始日期、endDate 结束日期、customerName 客户名称、shipperName 运货商名称、shipProvince 收货省份、
     * shipCity 收货城市、 shipRegion 收货地区获得一般的订单信息
     *
     * @param orderPageQueryParam 分页查询条件
     * @return 分页显示订单的一般信息
     */
    Pageable<Order> page(OrderPageQueryParam orderPageQueryParam);

    /**
     * 根据startDate 起始日期、endDate 结束日期、customerName 客户名称、shipperName 运货商名称、shipProvince 收货省份、
     * shipCity 收货城市、 shipRegion 收货地区获得一般的订单信息
     *
     * @param employeeId 员工号
     * @param orderPageQueryParam 分页查询条件
     * @return 分页显示订单的一般信息
     */
    Pageable<Order> pageByEmployeeId(String employeeId, OrderPageQueryParam orderPageQueryParam);

    /**
     * 根据customerId 客户号、 startDate 起始日期、endDate 结束日期、customerName 客户名称、shipperName 运货商名称、
     * shipProvince 收货省份、 shipCity 收货城市、 shipRegion 收货地区获得一般的订单信息
     *
     * @param customerId 客户号
     * @param orderPageQueryParam 分页查询条件
     * @return 分页显示订单的一般信息
     */
    Pageable<Order> pageByCustomerId(Integer customerId, OrderPageQueryParam orderPageQueryParam);

    /**
     * 根据shipperId 运货商号、 startDate 起始日期、endDate 结束日期、customerName 客户名称、shipperName 运货商名称、
     * shipProvince 收货省份、 shipCity 收货城市、 shipRegion 收货地区获得一般的订单信息
     *
     * @param shipperId 运货商号
     * @param orderPageQueryParam 分页查询条件
     * @return 分页显示订单的一般信息
     */
    Pageable<Order> pageByShipperId(Integer shipperId, OrderPageQueryParam orderPageQueryParam);

}
