package nxu.it.api.service.mongo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import nxu.it.api.common.result.Pageable;
import nxu.it.model.Product;
import nxu.it.model.ProductPageQueryParam;
import nxu.it.model.PurchasePageQueryParam;
import nxu.it.service.ProductService;
import org.bson.conversions.Bson;

import javax.inject.Inject;
import java.util.List;

public class ProductServiceMongoImpl implements ProductService {
    @Inject
    MongoDatabase db;

    @Override
    public List<Product> findByProductId(Integer productId) {
        MongoCollection<Product> productCollection = db.getCollection("product", Product.class);
        Bson idFilter = Filters.eq("_id", productId);
        return null;
    }

    @Override
    public Pageable<Product> page(ProductPageQueryParam productPageQueryParam) {
        return null;
    }

    @Override
    public Pageable<Product> pageBySupplierId(Integer supplierId, ProductPageQueryParam productPageQueryParam) {
        return null;
    }

    @Override
    public Pageable<Product> purchasePage(PurchasePageQueryParam purchasePageQueryParam) {
        return null;
    }
}
