package nxu.it.api.service.mongo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import nxu.it.api.common.result.Pageable;
import nxu.it.api.service.mongo.entity.ProductEntity;
import nxu.it.api.service.mongo.mapper.ProductMapper;
import nxu.it.model.Product;
import nxu.it.model.ProductPageQueryParam;
import nxu.it.model.PurchasePageQueryParam;
import nxu.it.service.ProductService;
import org.bson.conversions.Bson;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
public class ProductServiceMongoImpl implements ProductService {
    @Inject
    MongoDatabase db;
    @Inject
    ProductMapper productMapper;

    @Override
    public List<Product> findByProductId(Integer productId) {
        MongoCollection<ProductEntity> productEntityCollection = db.getCollection("product", ProductEntity.class);
        Bson idFilter = Filters.eq("_id", productId);
        ArrayList<ProductEntity> productEntityList = productEntityCollection.find(idFilter).into(new ArrayList<>());
        List<Product> productList = productMapper.toProductList(productEntityList);
        return productList;
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
