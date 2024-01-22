package nxu.it.service;

import nxu.it.api.common.result.Pageable;
import nxu.it.model.Supplier;
import nxu.it.model.SupplierPageQueryParam;

public interface SupplierService {
    /**
     * 根据name 名称查询供应商信息
     *
     * @param supplierPageQueryParam 分页查询条件
     * @return 分页显示供应商信息
     */
    Pageable<Supplier> page(SupplierPageQueryParam supplierPageQueryParam);
}
