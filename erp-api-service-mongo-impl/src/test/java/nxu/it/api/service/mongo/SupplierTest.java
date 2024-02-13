package nxu.it.api.service.mongo;

import io.quarkus.test.junit.QuarkusTest;
import nxu.it.api.common.result.Pageable;
import nxu.it.model.Supplier;
import nxu.it.model.SupplierPageQueryParam;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class SupplierTest {
    @Inject
    SupplierServiceMongoImpl supplierServiceMongo;

    @Test
    void test_page() {
        SupplierPageQueryParam supplierPageQueryParam = new SupplierPageQueryParam();
        supplierPageQueryParam.setPageSize(5);
        supplierPageQueryParam.setPageNumber(1);

        supplierPageQueryParam.setName("广");

        Pageable<Supplier> supplierPageable = supplierServiceMongo.page(supplierPageQueryParam);
        System.out.println(supplierPageable.getList());
    }
}
