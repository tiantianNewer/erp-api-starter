package nxu.it.api.service.mongo;

import cn.hutool.core.util.PageUtil;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import nxu.it.api.common.result.BasePage;
import nxu.it.api.common.result.Pageable;
import nxu.it.api.service.mongo.entity.OrdersEntity;
import nxu.it.api.service.mongo.mapper.OrderMapper;
import nxu.it.model.Order;
import nxu.it.model.OrderDetail;
import nxu.it.model.OrderPageQueryParam;
import nxu.it.service.OrderService;
import org.bson.conversions.Bson;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrderServiceMongoImpl implements OrderService {
    @Inject
    MongoDatabase db;
    @Inject
    OrderMapper orderMapper;
    @Override
    public Optional<Order> findByOrderId(String id) {
        MongoCollection<OrdersEntity> ordersEntityCollection = db.getCollection("orders", OrdersEntity.class);
        Bson idFilter = Filters.eq("_id", id);
        OrdersEntity ordersEntity = ordersEntityCollection.find(idFilter).first();
        if (ordersEntity==null) {
            return Optional.empty();
        }
        Order order = orderMapper.toOrder(ordersEntity);
        List<OrderDetail> detailList = order.getDetailList();
        order.setTotalPrice(detailList.stream().mapToDouble(OrderDetail::getTotalPrice).sum());
        return Optional.of(order);
    }

    @Override
    public Pageable<Order> page(OrderPageQueryParam orderPageQueryParam) {
        LocalDateTime startDate = orderPageQueryParam.getStartDate();
        LocalDateTime endDate = orderPageQueryParam.getEndDate();
        String customerName = orderPageQueryParam.getCustomerName();
        String shipperName = orderPageQueryParam.getShipperName();
        String shipProvince = orderPageQueryParam.getShipProvince();
        String shipCity = orderPageQueryParam.getShipCity();
        String shipRegion = orderPageQueryParam.getShipRegion();
        String employeeName = orderPageQueryParam.getEmployeeName();

        ArrayList<Bson> filterList = new ArrayList<>();
        if (startDate!=null && endDate!=null) {
            Bson startDateFilter = Filters.gte("orderDate", startDate);
            Bson endDateFilter = Filters.lte("orderDate", endDate);
            Bson orderDateFilter = Filters.and(startDateFilter, endDateFilter);
            filterList.add(orderDateFilter);
        }
        if (customerName!=null && !customerName.isBlank()) {
            Bson customerNameFilter = Filters.regex("customer.name",
                    String.format(".*%s.*", customerName), "i");
            filterList.add(customerNameFilter);
        }
        if (shipperName!=null && !shipperName.isBlank()) {
            Bson shipperNameFilter = Filters.regex("shipInfo.shipper.name",
                    String.format(".*%s.*", shipperName), "i");
            filterList.add(shipperNameFilter);
        }
        if (shipProvince!=null && !shipProvince.isBlank()) {
            Bson shipProvinceFilter = Filters.regex("shipInfo.shipProvince",
                    String.format(".*%s.*", shipProvince), "i");
            filterList.add(shipProvinceFilter);
        }
        if (shipCity!=null && !shipCity.isBlank()) {
            Bson shipCityFilter = Filters.regex("shipInfo.shipCity",
                    String.format(".*%s.*", shipCity), "i");
            filterList.add(shipCityFilter);
        }
        if (shipRegion!=null && !shipRegion.isBlank()) {
            Bson shipRegionFilter = Filters.regex("shipInfo.shipRegion",
                    String.format(".*%s.*", shipRegion), "i");
            filterList.add(shipRegionFilter);
        }
        if (employeeName!=null && !employeeName.isBlank()) {
            Bson employeeNameFilter = Filters.regex("employee.name",
                    String.format(".*%s.*", employeeName), "i");
            filterList.add(employeeNameFilter);
        }

        MongoCollection<OrdersEntity> ordersCollection = db.getCollection("orders", OrdersEntity.class);
        Bson allFilters = filterList.isEmpty() ? Filters.empty() : Filters.and(filterList);

        long totalRow = ordersCollection.countDocuments(allFilters);
        int pageSize = orderPageQueryParam.getPageSize();
        int pageNumber = orderPageQueryParam.getPageNumber();
        PageUtil.setOneAsFirstPageNo();
        int totalPage = PageUtil.totalPage(totalRow, pageSize);
        int offset = PageUtil.getStart(pageNumber, pageSize);
        ArrayList<OrdersEntity> orderEntityList = ordersCollection.find(allFilters)
                .skip(offset).limit(pageSize)
                .projection(Projections.exclude("details"))
                .into(new ArrayList<>());
        List<Order> orderList = orderMapper.toOrderList(orderEntityList);
        BasePage<Order> orderPage = new BasePage<>(orderList, pageNumber, pageSize, totalPage, (int) totalRow);
        return orderPage;
    }

    @Override
    public Pageable<Order> pageByEmployeeId(String employeeId, OrderPageQueryParam orderPageQueryParam) {
        LocalDateTime startDate = orderPageQueryParam.getStartDate();
        LocalDateTime endDate = orderPageQueryParam.getEndDate();
        String customerName = orderPageQueryParam.getCustomerName();
        String shipperName = orderPageQueryParam.getShipperName();
        String shipProvince = orderPageQueryParam.getShipProvince();
        String shipCity = orderPageQueryParam.getShipCity();
        String shipRegion = orderPageQueryParam.getShipRegion();
        String employeeName = orderPageQueryParam.getEmployeeName();

        ArrayList<Bson> filterList = new ArrayList<>();
        Bson employeeIdFilter = Filters.eq("employee.id", employeeId);
        filterList.add(employeeIdFilter);
        if (startDate!=null && endDate!=null) {
            Bson startDateFilter = Filters.gte("orderDate", startDate);
            Bson endDateFilter = Filters.lte("orderDate", endDate);
            Bson orderDateFilter = Filters.and(startDateFilter, endDateFilter);
            filterList.add(orderDateFilter);
        }
        if (customerName!=null && !customerName.isBlank()) {
            Bson customerNameFilter = Filters.regex("customer.name",
                    String.format(".*%s.*", customerName), "i");
            filterList.add(customerNameFilter);
        }
        if (shipperName!=null && !shipperName.isBlank()) {
            Bson shipperNameFilter = Filters.regex("shipInfo.shipper.name",
                    String.format(".*%s.*", shipperName), "i");
            filterList.add(shipperNameFilter);
        }
        if (shipProvince!=null && !shipProvince.isBlank()) {
            Bson shipProvinceFilter = Filters.regex("shipInfo.shipProvince",
                    String.format(".*%s.*", shipProvince), "i");
            filterList.add(shipProvinceFilter);
        }
        if (shipCity!=null && !shipCity.isBlank()) {
            Bson shipCityFilter = Filters.regex("shipInfo.shipCity",
                    String.format(".*%s.*", shipCity), "i");
            filterList.add(shipCityFilter);
        }
        if (shipRegion!=null && !shipRegion.isBlank()) {
            Bson shipRegionFilter = Filters.regex("shipInfo.shipRegion",
                    String.format(".*%s.*", shipRegion), "i");
            filterList.add(shipRegionFilter);
        }
        if (employeeName!=null && !employeeName.isBlank()) {
            Bson employeeNameFilter = Filters.regex("employee.name",
                    String.format(".*%s.*", employeeName), "i");
            filterList.add(employeeNameFilter);
        }

        MongoCollection<OrdersEntity> ordersCollection = db.getCollection("orders", OrdersEntity.class);
        Bson allFilters = filterList.isEmpty() ? Filters.empty() : Filters.and(filterList);

        long totalRow = ordersCollection.countDocuments(allFilters);
        int pageSize = orderPageQueryParam.getPageSize();
        int pageNumber = orderPageQueryParam.getPageNumber();
        PageUtil.setOneAsFirstPageNo();
        int totalPage = PageUtil.totalPage(totalRow, pageSize);
        int offset = PageUtil.getStart(pageNumber, pageSize);
        ArrayList<OrdersEntity> orderEntityList = ordersCollection.find(allFilters)
                .skip(offset).limit(pageSize)
                .projection(Projections.exclude("details"))
                .into(new ArrayList<>());
        List<Order> orderList = orderMapper.toOrderList(orderEntityList);
        BasePage<Order> orderPage = new BasePage<>(orderList, pageNumber, pageSize, totalPage, (int) totalRow);
        return orderPage;
    }

    @Override
    public Pageable<Order> pageByCustomerId(Integer customerId, OrderPageQueryParam orderPageQueryParam) {
        LocalDateTime startDate = orderPageQueryParam.getStartDate();
        LocalDateTime endDate = orderPageQueryParam.getEndDate();
        String customerName = orderPageQueryParam.getCustomerName();
        String shipperName = orderPageQueryParam.getShipperName();
        String shipProvince = orderPageQueryParam.getShipProvince();
        String shipCity = orderPageQueryParam.getShipCity();
        String shipRegion = orderPageQueryParam.getShipRegion();
        String employeeName = orderPageQueryParam.getEmployeeName();

        ArrayList<Bson> filterList = new ArrayList<>();
        Bson customerIdFilter = Filters.eq("customer.id", customerId);
        filterList.add(customerIdFilter);
        if (startDate!=null && endDate!=null) {
            Bson startDateFilter = Filters.gte("orderDate", startDate);
            Bson endDateFilter = Filters.lte("orderDate", endDate);
            Bson orderDateFilter = Filters.and(startDateFilter, endDateFilter);
            filterList.add(orderDateFilter);
        }
        if (customerName!=null && !customerName.isBlank()) {
            Bson customerNameFilter = Filters.regex("customer.name",
                    String.format(".*%s.*", customerName), "i");
            filterList.add(customerNameFilter);
        }
        if (shipperName!=null && !shipperName.isBlank()) {
            Bson shipperNameFilter = Filters.regex("shipInfo.shipper.name",
                    String.format(".*%s.*", shipperName), "i");
            filterList.add(shipperNameFilter);
        }
        if (shipProvince!=null && !shipProvince.isBlank()) {
            Bson shipProvinceFilter = Filters.regex("shipInfo.shipProvince",
                    String.format(".*%s.*", shipProvince), "i");
            filterList.add(shipProvinceFilter);
        }
        if (shipCity!=null && !shipCity.isBlank()) {
            Bson shipCityFilter = Filters.regex("shipInfo.shipCity",
                    String.format(".*%s.*", shipCity), "i");
            filterList.add(shipCityFilter);
        }
        if (shipRegion!=null && !shipRegion.isBlank()) {
            Bson shipRegionFilter = Filters.regex("shipInfo.shipRegion",
                    String.format(".*%s.*", shipRegion), "i");
            filterList.add(shipRegionFilter);
        }
        if (employeeName!=null && !employeeName.isBlank()) {
            Bson employeeNameFilter = Filters.regex("employee.name",
                    String.format(".*%s.*", employeeName), "i");
            filterList.add(employeeNameFilter);
        }

        MongoCollection<OrdersEntity> ordersCollection = db.getCollection("orders", OrdersEntity.class);
        Bson allFilters = filterList.isEmpty() ? Filters.empty() : Filters.and(filterList);

        long totalRow = ordersCollection.countDocuments(allFilters);
        int pageSize = orderPageQueryParam.getPageSize();
        int pageNumber = orderPageQueryParam.getPageNumber();
        PageUtil.setOneAsFirstPageNo();
        int totalPage = PageUtil.totalPage(totalRow, pageSize);
        int offset = PageUtil.getStart(pageNumber, pageSize);
        ArrayList<OrdersEntity> orderEntityList = ordersCollection.find(allFilters)
                .skip(offset).limit(pageSize)
                .projection(Projections.exclude("details"))
                .into(new ArrayList<>());
        List<Order> orderList = orderMapper.toOrderList(orderEntityList);
        BasePage<Order> orderPage = new BasePage<>(orderList, pageNumber, pageSize, totalPage, (int) totalRow);
        return orderPage;
    }

    @Override
    public Pageable<Order> pageByShipperId(Integer shipperId, OrderPageQueryParam orderPageQueryParam) {
        LocalDateTime startDate = orderPageQueryParam.getStartDate();
        LocalDateTime endDate = orderPageQueryParam.getEndDate();
        String customerName = orderPageQueryParam.getCustomerName();
        String shipperName = orderPageQueryParam.getShipperName();
        String shipProvince = orderPageQueryParam.getShipProvince();
        String shipCity = orderPageQueryParam.getShipCity();
        String shipRegion = orderPageQueryParam.getShipRegion();
        String employeeName = orderPageQueryParam.getEmployeeName();

        ArrayList<Bson> filterList = new ArrayList<>();
        Bson shipperIdFilter = Filters.eq("shipInfo.shipper.id", shipperId);
        filterList.add(shipperIdFilter);
        if (startDate!=null && endDate!=null) {
            Bson startDateFilter = Filters.gte("orderDate", startDate);
            Bson endDateFilter = Filters.lte("orderDate", endDate);
            Bson orderDateFilter = Filters.and(startDateFilter, endDateFilter);
            filterList.add(orderDateFilter);
        }
        if (customerName!=null && !customerName.isBlank()) {
            Bson customerNameFilter = Filters.regex("customer.name",
                    String.format(".*%s.*", customerName), "i");
            filterList.add(customerNameFilter);
        }
        if (shipperName!=null && !shipperName.isBlank()) {
            Bson shipperNameFilter = Filters.regex("shipInfo.shipper.name",
                    String.format(".*%s.*", shipperName), "i");
            filterList.add(shipperNameFilter);
        }
        if (shipProvince!=null && !shipProvince.isBlank()) {
            Bson shipProvinceFilter = Filters.regex("shipInfo.shipProvince",
                    String.format(".*%s.*", shipProvince), "i");
            filterList.add(shipProvinceFilter);
        }
        if (shipCity!=null && !shipCity.isBlank()) {
            Bson shipCityFilter = Filters.regex("shipInfo.shipCity",
                    String.format(".*%s.*", shipCity), "i");
            filterList.add(shipCityFilter);
        }
        if (shipRegion!=null && !shipRegion.isBlank()) {
            Bson shipRegionFilter = Filters.regex("shipInfo.shipRegion",
                    String.format(".*%s.*", shipRegion), "i");
            filterList.add(shipRegionFilter);
        }
        if (employeeName!=null && !employeeName.isBlank()) {
            Bson employeeNameFilter = Filters.regex("employee.name",
                    String.format(".*%s.*", employeeName), "i");
            filterList.add(employeeNameFilter);
        }

        MongoCollection<OrdersEntity> ordersCollection = db.getCollection("orders", OrdersEntity.class);
        Bson allFilters = filterList.isEmpty() ? Filters.empty() : Filters.and(filterList);

        long totalRow = ordersCollection.countDocuments(allFilters);
        int pageSize = orderPageQueryParam.getPageSize();
        int pageNumber = orderPageQueryParam.getPageNumber();
        PageUtil.setOneAsFirstPageNo();
        int totalPage = PageUtil.totalPage(totalRow, pageSize);
        int offset = PageUtil.getStart(pageNumber, pageSize);
        ArrayList<OrdersEntity> orderEntityList = ordersCollection.find(allFilters)
                .skip(offset).limit(pageSize)
                .projection(Projections.exclude("details"))
                .into(new ArrayList<>());
        List<Order> orderList = orderMapper.toOrderList(orderEntityList);
        BasePage<Order> orderPage = new BasePage<>(orderList, pageNumber, pageSize, totalPage, (int) totalRow);
        return orderPage;
    }
}
