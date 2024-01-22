package nxu.it.service.pg;

import io.quarkus.test.junit.QuarkusTest;
import nxu.it.api.common.result.Pageable;
import nxu.it.api.service.pg.ShipperServicePgImpl;
import nxu.it.model.Shipper;
import nxu.it.model.ShipperPageQueryParam;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class ShipperTest {
    @Inject
    ShipperServicePgImpl shipperServicePg;

    @Test
    void test_page() {
        ShipperPageQueryParam shipperPageQueryParam = new ShipperPageQueryParam();
        shipperPageQueryParam.setPageSize(5);
        shipperPageQueryParam.setPageNumber(1);

        shipperPageQueryParam.setName("快");

        Pageable<Shipper> shipperPageable = shipperServicePg.page(shipperPageQueryParam);
        System.out.println(shipperPageable.getList());
    }
}
