package nxu.it.api.service.pg;

import cn.hutool.core.util.PageUtil;
import nxu.it.api.common.result.BasePage;
import nxu.it.api.common.result.Pageable;
import nxu.it.api.service.pg.dao.ProductDao;
import nxu.it.api.service.pg.entity.ProductEntity;
import nxu.it.api.service.pg.mapper.ProductMapper;
import nxu.it.model.Product;
import nxu.it.model.ProductPageQueryParam;
import nxu.it.model.PurchasePageQueryParam;
import nxu.it.service.ProductService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProductServicePgImpl implements ProductService {
    @Inject
    ProductDao productDao;
    @Inject
    ProductMapper productMapper;

    @Override
    public List<Product> findByProductId(Integer productId) {
        List<ProductEntity> productEntityList = productDao.findByProductId(productId);
        return productMapper.toProductList(productEntityList);
    }

    @Override
    public Pageable<Product> page(ProductPageQueryParam productPageQueryParam) {
        List<ProductEntity> productEntityList = productDao.page(productPageQueryParam.getName(), productPageQueryParam.getBrand(),
                productPageQueryParam.getCategoryId(), productPageQueryParam.getMinPrice(), productPageQueryParam.getMaxPrice(), productPageQueryParam.getHaveProduct());
        List<Product> productList = productMapper.toProductList(productEntityList);

        int totalRow = productList.size();
        int pageSize = productPageQueryParam.getPageSize();
        int pageNumber = productPageQueryParam.getPageNumber();
        int totalPage = PageUtil.totalPage(totalRow, pageSize);

        PageUtil.setOneAsFirstPageNo();
        int start = PageUtil.getStart(pageNumber, pageSize);
        int end = Math.min(start + pageSize, totalRow);
        List<Product> subList = new ArrayList<>();
        if (start < end) {
            subList = productList.subList(start, end);
        }
        return new BasePage<>(subList, pageNumber, pageSize, totalPage, totalRow);
    }

    @Override
    public Pageable<Product> pageBySupplierId(Integer supplierId, ProductPageQueryParam productPageQueryParam) {
        List<ProductEntity> productEntityList = productDao.pageBySupplierId(supplierId, productPageQueryParam.getName(), productPageQueryParam.getBrand(),
                productPageQueryParam.getCategoryId(), productPageQueryParam.getMinPrice(), productPageQueryParam.getMaxPrice(), productPageQueryParam.getHaveProduct());
        List<Product> productList = productMapper.toProductList(productEntityList);

        int totalRow = productList.size();
        int pageSize = productPageQueryParam.getPageSize();
        int pageNumber = productPageQueryParam.getPageNumber();
        int totalPage = PageUtil.totalPage(totalRow, pageSize);

        PageUtil.setOneAsFirstPageNo();
        int start = PageUtil.getStart(pageNumber, pageSize);
        int end = Math.min(start + pageSize, totalRow);
        List<Product> subList = new ArrayList<>();
        if (start < end) {
            subList = productList.subList(start, end);
        }
        return new BasePage<>(subList, pageNumber, pageSize, totalPage, totalRow);
    }

    @Override
    public Pageable<Product> purchasePage(PurchasePageQueryParam purchasePageQueryParam) {
        List<ProductEntity> productEntityList = productDao.purchasePage(purchasePageQueryParam.getProductName(), purchasePageQueryParam.getSupplierName(),
                purchasePageQueryParam.getStartDate(), purchasePageQueryParam.getEndDate());
        List<Product> productList = productMapper.toProductList(productEntityList);

        int totalRow = productList.size();
        int pageSize = purchasePageQueryParam.getPageSize();
        int pageNumber = purchasePageQueryParam.getPageNumber();
        int totalPage = PageUtil.totalPage(totalRow, pageSize);

        PageUtil.setOneAsFirstPageNo();
        int start = PageUtil.getStart(pageNumber, pageSize);
        int end = Math.min(start + pageSize, totalRow);
        List<Product> subList = new ArrayList<>();
        if (start < end) {
            subList = productList.subList(start, end);
        }
        return new BasePage<>(subList, pageNumber, pageSize, totalPage, totalRow);
    }
}
