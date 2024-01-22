package nxu.it.service;

import nxu.it.api.common.result.Pageable;
import nxu.it.model.Customer;
import nxu.it.model.CustomerPageQueryParam;

public interface CustomerService {
    /**
     * 根据name 名称、region 地区、province 省、city 城市查询顾客信息
     *
     * @param customerPageQueryParam 分页查询条件
     * @return 分页显示顾客信息
     */
    Pageable<Customer> page(CustomerPageQueryParam customerPageQueryParam);
}
