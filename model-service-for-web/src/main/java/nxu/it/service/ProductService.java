package nxu.it.service;

import nxu.it.model.Product;
import nxu.it.model.ProductPageQueryParam;
import nxu.it.api.common.result.Pageable;
import nxu.it.model.PurchasePageQueryParam;

import java.util.List;

public interface ProductService {

    /**
     * 根据产品编号获得产品信息
     *
     * @param productId 产品编号
     * @return 指定编号的产品信息
     */
    List<Product> findByProductId(Integer productId);

    /**
     * 根据name 产品名字、brand 品牌、categoryId 产品父类型、minPrice 价格范围内小值、
     * maxPrice 价格范围内大值、haveProduct 有库存参数获得产品信息
     *
     * @param productPageQueryParam 分页查询条件
     * @return 产品分页记录
     */
    Pageable<Product> page(ProductPageQueryParam productPageQueryParam);

    /**
     * 根据supplierId 供应商id、name 产品名字、brand 品牌、
     * categoryId 产品父类型、minPrice 价格范围内小值、
     * maxPrice 价格范围内大值、haveProduct 有库存参数获得产品信息
     *
     * @param supplierId 供应商id
     * @param productPageQueryParam 分页查询条件
     * @return 产品分页记录
     */
    Pageable<Product> pageBySupplierId(Integer supplierId, ProductPageQueryParam productPageQueryParam);

    /**
     * 根据name 产品名字、 supplierName 供应商名称、 startDate 进货日期范围内小值、 endDate 进货日期范围内大值
     *
     * @param purchasePageQueryParam 分页查询条件
     * @return 产品分页记录
     */
    Pageable<Product> purchasePage(PurchasePageQueryParam purchasePageQueryParam);

}
