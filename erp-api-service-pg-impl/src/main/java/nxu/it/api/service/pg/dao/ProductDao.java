package nxu.it.api.service.pg.dao;

import nxu.it.api.service.pg.entity.ProductEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import java.time.LocalDate;
import java.util.List;

@Dao
public interface ProductDao {
    @Select
    List<ProductEntity> findByProductId(Integer productId);
    @Select
    List<ProductEntity> page(String name, String brand, String categoryId, Float minPrice, Float maxPrice, Boolean haveProduct);
    @Select
    List<ProductEntity> pageBySupplierId(Integer supplierId, String name, String brand, String categoryId, Float minPrice, Float maxPrice, Boolean haveProduct);
    @Select
    List<ProductEntity> purchasePage(String name, String supplierName, LocalDate startDate, LocalDate endDate);
}
