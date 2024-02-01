package nxu.it.api.service.pg;

import cn.hutool.core.util.PageUtil;
import nxu.it.api.common.result.BasePage;
import nxu.it.api.common.result.Pageable;
import nxu.it.api.service.pg.dao.OrderDao;
import nxu.it.api.service.pg.entity.OrderEntity;
import nxu.it.api.service.pg.mapper.OrderMapper;
import nxu.it.model.Order;
import nxu.it.model.OrderDetail;
import nxu.it.model.OrderPageQueryParam;
import nxu.it.service.OrderService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrderServicePgImpl implements OrderService {
    @Inject
    OrderDao orderDao;
    @Inject
    OrderMapper orderMapper;
    @Override
    public Optional<Order> findByOrderId(String id) {
        OrderEntity orderEntity = orderDao.findByOrderId(id);
        if (orderEntity == null) {
            return Optional.empty();
        }
        Order order = orderMapper.toOrder(orderEntity);
        List<OrderDetail> orderDetailList = orderMapper.toOrderDetailList(orderDao.findDetailByOrderId(id));
        order.setDetailList(orderDetailList);
        order.setTotalPrice(orderDetailList.stream().mapToDouble(OrderDetail::getTotalPrice).sum());
        return Optional.of(order);
    }

    @Override
    public Pageable<Order> page(OrderPageQueryParam orderPageQueryParam) {
        List<OrderEntity> orderEntityList = orderDao.page(orderPageQueryParam.getStartDate(), orderPageQueryParam.getEndDate(), orderPageQueryParam.getCustomerName(), orderPageQueryParam.getShipperName(),
                orderPageQueryParam.getShipProvince(), orderPageQueryParam.getShipCity(), orderPageQueryParam.getShipRegion(), orderPageQueryParam.getEmployeeName());
        List<Order> orderList = orderMapper.toOrderList(orderEntityList);

        int totalRow = orderList.size();
        int pageSize = orderPageQueryParam.getPageSize();
        int pageNumber = orderPageQueryParam.getPageNumber();
        int totalPage = PageUtil.totalPage(totalRow, pageSize);

        PageUtil.setOneAsFirstPageNo();
        int start = PageUtil.getStart(pageNumber, pageSize);
        int end = Math.min(start + pageSize, totalRow);
        List<Order> subList = new ArrayList<>();
        if (start < end) {
            subList = orderList.subList(start, end);
        }
        return new BasePage<>(subList, pageNumber, pageSize, totalPage, totalRow);
    }

    @Override
    public Pageable<Order> pageByEmployeeId(String employeeId, OrderPageQueryParam orderPageQueryParam) {
        List<OrderEntity> orderEntityList = orderDao.pageByEmployeeId(employeeId ,orderPageQueryParam.getStartDate(), orderPageQueryParam.getEndDate(), orderPageQueryParam.getCustomerName(), orderPageQueryParam.getShipperName(),
                orderPageQueryParam.getShipProvince(), orderPageQueryParam.getShipCity(), orderPageQueryParam.getShipRegion());
        List<Order> orderList = orderMapper.toOrderList(orderEntityList);

        int totalRow = orderList.size();
        int pageSize = orderPageQueryParam.getPageSize();
        int pageNumber = orderPageQueryParam.getPageNumber();
        int totalPage = PageUtil.totalPage(totalRow, pageSize);

        PageUtil.setOneAsFirstPageNo();
        int start = PageUtil.getStart(pageNumber, pageSize);
        int end = Math.min(start + pageSize, totalRow);
        List<Order> subList = new ArrayList<>();
        if (start < end) {
            subList = orderList.subList(start, end);
        }
        return new BasePage<>(subList, pageNumber, pageSize, totalPage, totalRow);
    }

    @Override
    public Pageable<Order> pageByCustomerId(Integer customerId, OrderPageQueryParam orderPageQueryParam) {
        List<OrderEntity> orderEntityList = orderDao.pageByCustomerId(customerId, orderPageQueryParam.getStartDate(), orderPageQueryParam.getEndDate(), orderPageQueryParam.getShipperName(),
                orderPageQueryParam.getShipProvince(), orderPageQueryParam.getShipCity(), orderPageQueryParam.getShipRegion(), orderPageQueryParam.getEmployeeName());
        List<Order> orderList = orderMapper.toOrderList(orderEntityList);

        int totalRow = orderList.size();
        int pageSize = orderPageQueryParam.getPageSize();
        int pageNumber = orderPageQueryParam.getPageNumber();
        int totalPage = PageUtil.totalPage(totalRow, pageSize);

        PageUtil.setOneAsFirstPageNo();
        int start = PageUtil.getStart(pageNumber, pageSize);
        int end = Math.min(start + pageSize, totalRow);
        List<Order> subList = new ArrayList<>();
        if (start < end) {
            subList = orderList.subList(start, end);
        }
        return new BasePage<>(subList, pageNumber, pageSize, totalPage, totalRow);
    }

    @Override
    public Pageable<Order> pageByShipperId(Integer shipperId, OrderPageQueryParam orderPageQueryParam) {
        List<OrderEntity> orderEntityList = orderDao.pageByShipperId(shipperId, orderPageQueryParam.getStartDate(), orderPageQueryParam.getEndDate(), orderPageQueryParam.getCustomerName(),
                orderPageQueryParam.getShipProvince(), orderPageQueryParam.getShipCity(), orderPageQueryParam.getShipRegion(), orderPageQueryParam.getEmployeeName());
        List<Order> orderList = orderMapper.toOrderList(orderEntityList);

        int totalRow = orderList.size();
        int pageSize = orderPageQueryParam.getPageSize();
        int pageNumber = orderPageQueryParam.getPageNumber();
        int totalPage = PageUtil.totalPage(totalRow, pageSize);

        PageUtil.setOneAsFirstPageNo();
        int start = PageUtil.getStart(pageNumber, pageSize);
        int end = Math.min(start + pageSize, totalRow);
        List<Order> subList = new ArrayList<>();
        if (start < end) {
            subList = orderList.subList(start, end);
        }
        return new BasePage<>(subList, pageNumber, pageSize, totalPage, totalRow);
    }
}
