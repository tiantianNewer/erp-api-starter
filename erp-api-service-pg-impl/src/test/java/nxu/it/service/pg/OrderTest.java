package nxu.it.service.pg;

import io.quarkus.test.junit.QuarkusTest;

import nxu.it.api.common.result.Pageable;
import nxu.it.api.service.pg.OrderServicePgImpl;
import nxu.it.model.Order;
import nxu.it.model.OrderPageQueryParam;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@QuarkusTest
public class OrderTest {
    @Inject
    OrderServicePgImpl orderServicePg;

    @Test
    void test_find_by_order_id() {
        String orderId = "202001190001";
        System.out.println(orderServicePg.findByOrderId(orderId));
    }
    @Test
    void test_page() {
        OrderPageQueryParam orderPageQueryParam = new OrderPageQueryParam();
        orderPageQueryParam.setPageSize(5);
        orderPageQueryParam.setPageNumber(1);

        orderPageQueryParam.setStartDate( LocalDateTime.of(LocalDate.of(2019, 7, 3), LocalTime.of(10, 8, 0)) );
        orderPageQueryParam.setEndDate( LocalDateTime.of(LocalDate.of(2021, 12, 1), LocalTime.of(10, 8, 0)) );
        orderPageQueryParam.setCustomerName("商贸");
        orderPageQueryParam.setShipperName("圆通速递");
        orderPageQueryParam.setShipProvince("广东");

        Pageable<Order> orderPageable = orderServicePg.page(orderPageQueryParam);
        System.out.println(orderPageable.getList());
    }

    @Test
    void test_page_by_employee_id() {
        OrderPageQueryParam orderPageQueryParam = new OrderPageQueryParam();
        orderPageQueryParam.setPageSize(5);
        orderPageQueryParam.setPageNumber(1);

        String employeeId = "2017001";
        orderPageQueryParam.setShipCity("七台河");

        Pageable<Order> orderPageable = orderServicePg.pageByEmployeeId(employeeId, orderPageQueryParam);
        System.out.println(orderPageable.getList());
    }

    @Test
    void test_page_by_customer_id() {
        OrderPageQueryParam orderPageQueryParam = new OrderPageQueryParam();
        orderPageQueryParam.setPageSize(5);
        orderPageQueryParam.setPageNumber(1);

        int customerId = 78;
        orderPageQueryParam.setShipRegion("华");

        Pageable<Order> orderPageable = orderServicePg.pageByCustomerId(customerId, orderPageQueryParam);
        System.out.println(orderPageable.getList());
    }

    @Test
    void test_page_by_shipper_id() {
        OrderPageQueryParam orderPageQueryParam = new OrderPageQueryParam();
        orderPageQueryParam.setPageSize(5);
        orderPageQueryParam.setPageNumber(1);

        int shipperId = 4;
        orderPageQueryParam.setShipCity("北京");
        orderPageQueryParam.setEmployeeName("曹");

        Pageable<Order> orderPageable = orderServicePg.pageByShipperId(shipperId, orderPageQueryParam);
        System.out.println(orderPageable.getList());
    }
}
