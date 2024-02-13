package nxu.it.api.service.mongo;

import cn.hutool.core.util.PageUtil;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import nxu.it.api.common.result.BasePage;
import nxu.it.api.common.result.Pageable;
import nxu.it.api.service.mongo.entity.ProductEntity;
import nxu.it.api.service.mongo.entity.PurchaseEntity;
import nxu.it.api.service.mongo.mapper.ProductMapper;
import nxu.it.model.Product;
import nxu.it.model.ProductPageQueryParam;
import nxu.it.model.PurchasePageQueryParam;
import nxu.it.service.ProductService;
import org.bson.conversions.Bson;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
public class ProductServiceMongoImpl implements ProductService {
    @Inject
    MongoDatabase db;
    @Inject
    ProductMapper productMapper;

    @Override
    public List<Product> findByProductId(Integer id) {
        MongoCollection<ProductEntity> productEntityCollection = db.getCollection("product", ProductEntity.class);
        Bson idFilter = Filters.eq("_id", id);
        ArrayList<ProductEntity> productEntityList = productEntityCollection.find(idFilter).into(new ArrayList<>());
        List<Product> productList = productMapper.toProductList(productEntityList);
        return productList;
    }

    @Override
    public Pageable<Product> page(ProductPageQueryParam productPageQueryParam) {
        String name = productPageQueryParam.getName();
        String brand = productPageQueryParam.getBrand();
        String categoryId = productPageQueryParam.getCategoryId();
        Float minPrice = productPageQueryParam.getMinPrice();
        Float maxPrice = productPageQueryParam.getMaxPrice();
        Boolean haveProduct = productPageQueryParam.getHaveProduct();

        ArrayList<Bson> filterList = new ArrayList<>();
        if (name!=null && !name.isBlank()) {
            Bson nameFilter = Filters.regex("name",
                    String.format(".*%s.*", name), "i");
            filterList.add(nameFilter);
        }
        if (brand!=null && !brand.isBlank()) {
            Bson brandFilter = Filters.regex("brand",
                    String.format(".*%s.*", brand), "i");
            filterList.add(brandFilter);
        }
        if (categoryId!=null && !categoryId.isBlank()) {
            int length = categoryId.length();
            int category_id = Integer.parseInt(categoryId.replaceFirst("^0+", "")); //去掉开头的0;
            Bson categoryIdFilter;
            if (length == 2) {
                categoryIdFilter = Filters.eq("category.level1._id", category_id);
            } else if (length == 4) {
                categoryIdFilter = Filters.eq("category.level2._id", category_id);
            } else if (length == 6) {
                categoryIdFilter = Filters.eq("category.level3._id", category_id);
            } else {
                categoryIdFilter = null;
            }
            filterList.add(categoryIdFilter);
        }
        if (minPrice!=null && maxPrice!=null) {
            Bson minPriceFilter = Filters.gte("unitPrice", minPrice);
            Bson maxPriceFilter = Filters.lte("unitPrice", maxPrice);
            Bson unitPriceFilter = Filters.and(minPriceFilter, maxPriceFilter);
            filterList.add(unitPriceFilter);
        }
        if (haveProduct!=null) {
            Bson haveProductFilter;
            if (haveProduct) {
                haveProductFilter = Filters.gt("unitsInStock", 0);
            } else {
                haveProductFilter = Filters.eq("unitsInStock", 0);
            }
            filterList.add(haveProductFilter);
        }

        MongoCollection<ProductEntity> productCollection = db.getCollection("product", ProductEntity.class);
        Bson allFilters = filterList.isEmpty() ? Filters.empty() : Filters.and(filterList);

        long totalRow = productCollection.countDocuments(allFilters);
        int pageSize = productPageQueryParam.getPageSize();
        int pageNumber = productPageQueryParam.getPageNumber();
        PageUtil.setOneAsFirstPageNo();
        int totalPage = PageUtil.totalPage(totalRow, pageSize);
        int offset = PageUtil.getStart(pageNumber, pageSize);
        ArrayList<ProductEntity> productEntityList = productCollection.find(allFilters)
                .skip(offset).limit(pageSize)
                .projection(Projections.exclude("suppliers"))
                .into(new ArrayList<>());
        List<Product> productList = productMapper.toProductList(productEntityList);
        BasePage<Product> productPage = new BasePage<>(productList, pageNumber, pageSize, totalPage, (int) totalRow);
        return productPage;
    }

    @Override
    public Pageable<Product> pageBySupplierId(Integer supplierId, ProductPageQueryParam productPageQueryParam) {
        String name = productPageQueryParam.getName();
        String brand = productPageQueryParam.getBrand();
        String categoryId = productPageQueryParam.getCategoryId();
        Float minPrice = productPageQueryParam.getMinPrice();
        Float maxPrice = productPageQueryParam.getMaxPrice();
        Boolean haveProduct = productPageQueryParam.getHaveProduct();

        ArrayList<Bson> filterList = new ArrayList<>();
        Bson supplierIdFilter = Filters.elemMatch("suppliers", Filters.eq("id", supplierId));
        filterList.add(supplierIdFilter);
        if (name!=null && !name.isBlank()) {
            Bson nameFilter = Filters.regex("name",
                    String.format(".*%s.*", name), "i");
            filterList.add(nameFilter);
        }
        if (brand!=null && !brand.isBlank()) {
            Bson brandFilter = Filters.regex("brand",
                    String.format(".*%s.*", brand), "i");
            filterList.add(brandFilter);
        }
        if (categoryId!=null && !categoryId.isBlank()) {
            int length = categoryId.length();
            int category_id = Integer.parseInt(categoryId.replaceFirst("^0+", "")); //去掉开头的0;
            Bson categoryIdFilter;
            if (length == 2) {
                categoryIdFilter = Filters.eq("category.level1._id", category_id);
            } else if (length == 4) {
                categoryIdFilter = Filters.eq("category.level2._id", category_id);
            } else if (length == 6) {
                categoryIdFilter = Filters.eq("category.level3._id", category_id);
            } else {
                categoryIdFilter = null;
            }
            filterList.add(categoryIdFilter);
        }
        if (minPrice!=null && maxPrice!=null) {
            Bson minPriceFilter = Filters.gte("unitPrice", minPrice);
            Bson maxPriceFilter = Filters.lte("unitPrice", maxPrice);
            Bson unitPriceFilter = Filters.and(minPriceFilter, maxPriceFilter);
            filterList.add(unitPriceFilter);
        }
        if (haveProduct!=null) {
            Bson haveProductFilter;
            if (haveProduct) {
                haveProductFilter = Filters.gt("unitsInStock", 0);
            } else {
                haveProductFilter = Filters.eq("unitsInStock", 0);
            }
            filterList.add(haveProductFilter);
        }

        MongoCollection<ProductEntity> productCollection = db.getCollection("product", ProductEntity.class);
        Bson allFilters = filterList.isEmpty() ? Filters.empty() : Filters.and(filterList);

        long totalRow = productCollection.countDocuments(allFilters);
        int pageSize = productPageQueryParam.getPageSize();
        int pageNumber = productPageQueryParam.getPageNumber();
        PageUtil.setOneAsFirstPageNo();
        int totalPage = PageUtil.totalPage(totalRow, pageSize);
        int offset = PageUtil.getStart(pageNumber, pageSize);
        ArrayList<ProductEntity> productEntityList = productCollection.find(allFilters)
                .skip(offset).limit(pageSize)
                .projection(Projections.exclude("suppliers"))
                .into(new ArrayList<>());
        List<Product> productList = productMapper.toProductList(productEntityList);
        BasePage<Product> productPage = new BasePage<>(productList, pageNumber, pageSize, totalPage, (int) totalRow);
        return productPage;
    }

    @Override
    public Pageable<Product> purchasePage(PurchasePageQueryParam purchasePageQueryParam) {
        String productName = purchasePageQueryParam.getProductName();
        String supplierName = purchasePageQueryParam.getSupplierName();
        LocalDate startDate = purchasePageQueryParam.getStartDate();
        LocalDate endDate = purchasePageQueryParam.getEndDate();

        ArrayList<Bson> filterList = new ArrayList<>();
        if (productName!=null && !productName.isBlank()) {
            Bson productNameFilter = Filters.regex("product.name",
                    String.format(".*%s.*", productName), "i");
            filterList.add(productNameFilter);
        }
        if (supplierName!=null && !supplierName.isBlank()) {
            Bson supplierNameFilter = Filters.regex("supplier.name",
                    String.format(".*%s.*", supplierName), "i");
            filterList.add(supplierNameFilter);
        }
        if (startDate!=null && endDate!=null) {
            Bson startDateFilter = Filters.gte("purchaseDate", startDate);
            Bson endDateFilter = Filters.lte("purchaseDate", endDate);
            Bson purchaseDateFilter = Filters.and(startDateFilter, endDateFilter);
            filterList.add(purchaseDateFilter);
        }

        MongoCollection<PurchaseEntity> purchaseCollection = db.getCollection("purchase", PurchaseEntity.class);
        Bson allFilters = filterList.isEmpty() ? Filters.empty() : Filters.and(filterList);

        long totalRow = purchaseCollection.countDocuments(allFilters);
        int pageSize = purchasePageQueryParam.getPageSize();
        int pageNumber = purchasePageQueryParam.getPageNumber();
        PageUtil.setOneAsFirstPageNo();
        int totalPage = PageUtil.totalPage(totalRow, pageSize);
        int offset = PageUtil.getStart(pageNumber, pageSize);
        ArrayList<PurchaseEntity> purchaseEntityList = purchaseCollection.find(allFilters)
                .skip(offset).limit(pageSize)
                .into(new ArrayList<>());
        List<Product> productList = productMapper.purchasesToProductList(purchaseEntityList);
        BasePage<Product> productPage = new BasePage<>(productList, pageNumber, pageSize, totalPage, (int) totalRow);
        return productPage;
    }
}
