package nxu.it.api.service.pg;

import cn.hutool.core.util.PageUtil;
import nxu.it.api.common.result.BasePage;
import nxu.it.api.common.result.Pageable;
import nxu.it.api.service.pg.dao.SupplierDao;
import nxu.it.api.service.pg.entity.SupplierEntity;
import nxu.it.api.service.pg.mapper.SupplierMapper;
import nxu.it.model.Supplier;
import nxu.it.model.SupplierPageQueryParam;
import nxu.it.service.SupplierService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class SupplierServicePgImpl implements SupplierService {
    @Inject
    SupplierDao supplierDao;
    @Inject
    SupplierMapper supplierMapper;
    
    @Override
    public Pageable<Supplier> page(SupplierPageQueryParam supplierPageQueryParam) {
        List<SupplierEntity> supplierEntityList = supplierDao.page(supplierPageQueryParam.getName());
        List<Supplier> supplierList = supplierMapper.toSupplierList(supplierEntityList);

        int totalRow = supplierList.size();
        int pageSize = supplierPageQueryParam.getPageSize();
        int pageNumber = supplierPageQueryParam.getPageNumber();
        int totalPage = PageUtil.totalPage(totalRow, pageSize);

        PageUtil.setOneAsFirstPageNo();
        int start = PageUtil.getStart(pageNumber, pageSize);
        int end = Math.min(start + pageSize, totalRow);
        List<Supplier> subList = new ArrayList<>();
        if (start < end) {
            subList = supplierList.subList(start, end);
        }
        return new BasePage<>(subList, pageNumber, pageSize, totalPage, totalRow);
    }
}
