package nxu.it.api.service.mongo;

import io.quarkus.test.junit.QuarkusTest;
import nxu.it.api.common.result.Pageable;
import nxu.it.model.Customer;
import nxu.it.model.CustomerPageQueryParam;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class CustomerTest {
    @Inject
    CustomerServiceMongoImpl customerServiceMongo;

    @Test
    void test_page() {
        CustomerPageQueryParam customerPageQueryParam = new CustomerPageQueryParam();
        customerPageQueryParam.setPageSize(5);
        customerPageQueryParam.setPageNumber(1);

        customerPageQueryParam.setName("广");
//        customerPageQueryParam.setRegion("东");
//        customerPageQueryParam.setProvince("东");
        customerPageQueryParam.setCity("广");

        Pageable<Customer> customerPageable = customerServiceMongo.page(customerPageQueryParam);
        System.out.println(customerPageable.getList());
    }
}
