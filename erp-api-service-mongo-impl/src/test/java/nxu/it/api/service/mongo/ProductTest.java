/*
package nxu.it.api.service.mongo;

import io.quarkus.test.junit.QuarkusTest;
import nxu.it.api.common.result.Pageable;

import nxu.it.model.Product;
import nxu.it.model.ProductPageQueryParam;
import nxu.it.model.PurchasePageQueryParam;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.time.LocalDate;

@QuarkusTest
public class ProductTest {
    @Inject
    ProductServiceMongoImpl productServiceMongo;

    @Test
    void test_find_by_product_id() {
        int productId = 360441;
        System.out.println(productServiceMongo.findByProductId(productId));
    }
    @Test
    void test_page() {
        ProductPageQueryParam productPageQueryParam = new ProductPageQueryParam();
        productPageQueryParam.setPageSize(5);
        productPageQueryParam.setPageNumber(1);

        productPageQueryParam.setName("水");
        productPageQueryParam.setBrand("农");
//        productPageQueryParam.setCategoryId("01");
//        productPageQueryParam.setMinPrice((float)10.0);
//        productPageQueryParam.setMaxPrice((float)50.0);
//        productPageQueryParam.setHaveProduct(true);

        Pageable<Product> productPageable = productServiceMongo.page(productPageQueryParam);
        System.out.println(productPageable.getList());
    }
    @Test
    void test_page_by_supplier_id() {
        ProductPageQueryParam productPageQueryParam = new ProductPageQueryParam();
        productPageQueryParam.setPageSize(5);
        productPageQueryParam.setPageNumber(1);

        int supplierId = 87;
        productPageQueryParam.setHaveProduct(false);

        Pageable<Product> productPageable = productServiceMongo.pageBySupplierId(supplierId, productPageQueryParam);
        System.out.println(productPageable.getList());
    }
    @Test
    void test_purchasePage() {
        PurchasePageQueryParam purchasePageQueryParam = new PurchasePageQueryParam();
        purchasePageQueryParam.setPageSize(5);
        purchasePageQueryParam.setPageNumber(1);

        purchasePageQueryParam.setProductName("巾");
        purchasePageQueryParam.setSupplierName("周");
        purchasePageQueryParam.setStartDate(LocalDate.of(2018, 12, 10));
        purchasePageQueryParam.setEndDate(LocalDate.of(2020,1,1));

        Pageable<Product> purchasePageable = productServiceMongo.purchasePage(purchasePageQueryParam);
        System.out.println(purchasePageable.getList());
    }
}
*/
