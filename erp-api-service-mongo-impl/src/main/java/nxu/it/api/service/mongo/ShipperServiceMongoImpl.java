package nxu.it.api.service.mongo;

import cn.hutool.core.util.PageUtil;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import nxu.it.api.common.result.BasePage;
import nxu.it.api.common.result.Pageable;
import nxu.it.model.Shipper;
import nxu.it.model.ShipperPageQueryParam;
import nxu.it.service.ShipperService;
import org.bson.conversions.Bson;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;

@ApplicationScoped
public class ShipperServiceMongoImpl implements ShipperService {
    @Inject
    MongoDatabase db;
    @Override
    public Pageable<Shipper> page(ShipperPageQueryParam shipperPageQueryParam) {
        String name = shipperPageQueryParam.getName();
        Bson nameFilter = Filters.empty();
        if (name!=null && !name.isBlank()) {
             nameFilter = Filters.regex("name",
                    String.format(".*%s.*", name), "i");
        }

        MongoCollection<Shipper> shipperCollection = db.getCollection("shipper", Shipper.class);
        long totalRow = shipperCollection.countDocuments(nameFilter);
        int pageSize = shipperPageQueryParam.getPageSize();
        int pageNumber = shipperPageQueryParam.getPageNumber();
        PageUtil.setOneAsFirstPageNo();
        int totalPage = PageUtil.totalPage(totalRow, pageSize);
        int offset = PageUtil.getStart(pageNumber, pageSize);
        ArrayList<Shipper> shipperList = shipperCollection.find(nameFilter)
                .skip(offset).limit(pageSize)
                .into(new ArrayList<>());
        BasePage<Shipper> shipperPage = new BasePage<>(shipperList, pageNumber, pageSize, totalPage, (int) totalRow);
        return shipperPage;
    }
}
