package nxu.it.api.service.pg;

import cn.hutool.core.util.PageUtil;
import nxu.it.api.common.result.BasePage;
import nxu.it.api.common.result.Pageable;
import nxu.it.api.service.pg.dao.ShipperDao;
import nxu.it.api.service.pg.entity.ShipperEntity;
import nxu.it.api.service.pg.mapper.ShipperMapper;
import nxu.it.model.Shipper;
import nxu.it.model.ShipperPageQueryParam;
import nxu.it.service.ShipperService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ShipperServicePgImpl implements ShipperService {
    @Inject
    ShipperDao shipperDao;
    @Inject
    ShipperMapper shipperMapper;
    
    @Override
    public Pageable<Shipper> page(ShipperPageQueryParam shipperPageQueryParam) {
        List<ShipperEntity> shipperEntityList = shipperDao.page(shipperPageQueryParam.getName());
        List<Shipper> shipperList = shipperMapper.toShipperList(shipperEntityList);

        int totalRow = shipperList.size();
        int pageSize = shipperPageQueryParam.getPageSize();
        int pageNumber = shipperPageQueryParam.getPageNumber();
        int totalPage = PageUtil.totalPage(totalRow, pageSize);

        PageUtil.setOneAsFirstPageNo();
        int start = PageUtil.getStart(pageNumber, pageSize);
        int end = Math.min(start + pageSize, totalRow);
        List<Shipper> subList = new ArrayList<>();
        if (start < end) {
            subList = shipperList.subList(start, end);
        }
        return new BasePage<>(subList, pageNumber, pageSize, totalPage, totalRow);
    }
}
