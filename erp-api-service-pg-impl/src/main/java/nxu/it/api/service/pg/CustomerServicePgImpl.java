package nxu.it.api.service.pg;

import cn.hutool.core.util.PageUtil;
import nxu.it.api.common.result.BasePage;
import nxu.it.api.common.result.Pageable;
import nxu.it.api.service.pg.dao.CustomerDao;
import nxu.it.api.service.pg.entity.CustomerEntity;
import nxu.it.api.service.pg.mapper.CustomerMapper;
import nxu.it.model.Customer;
import nxu.it.model.CustomerPageQueryParam;
import nxu.it.service.CustomerService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CustomerServicePgImpl implements CustomerService {
    @Inject
    CustomerDao customerDao;
    @Inject
    CustomerMapper customerMapper;

    @Override
    public Pageable<Customer> page(CustomerPageQueryParam customerPageQueryParam) {
        List<CustomerEntity> customerEntityList = customerDao.page(customerPageQueryParam.getName(), customerPageQueryParam.getRegion(),
                customerPageQueryParam.getProvince(), customerPageQueryParam.getCity());
        List<Customer> customerList = customerMapper.toCustomerList(customerEntityList);

        int totalRow = customerList.size();
        int pageSize = customerPageQueryParam.getPageSize();
        int pageNumber = customerPageQueryParam.getPageNumber();
        int totalPage = PageUtil.totalPage(totalRow, pageSize);

        PageUtil.setOneAsFirstPageNo();
        int start = PageUtil.getStart(pageNumber, pageSize);
        int end = Math.min(start + pageSize, totalRow);
        List<Customer> subList = new ArrayList<>();
        if (start < end) {
            subList = customerList.subList(start, end);
        }
        return new BasePage<>(subList, pageNumber, pageSize, totalPage, totalRow);
    }
}
