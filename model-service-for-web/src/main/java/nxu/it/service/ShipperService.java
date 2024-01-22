package nxu.it.service;

import nxu.it.api.common.result.Pageable;
import nxu.it.model.Shipper;
import nxu.it.model.ShipperPageQueryParam;

public interface ShipperService {
    /**
     * 根据name 名称查询运货商信息
     * @param shipperPageQueryParam 分页查询条件
     * @return 分页显示运货商信息
     */
    Pageable<Shipper> page(ShipperPageQueryParam shipperPageQueryParam);
}
