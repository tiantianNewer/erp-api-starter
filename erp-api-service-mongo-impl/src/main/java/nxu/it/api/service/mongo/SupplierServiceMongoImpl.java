package nxu.it.api.service.mongo;

import cn.hutool.core.util.PageUtil;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import nxu.it.api.common.result.BasePage;
import nxu.it.api.common.result.Pageable;
import nxu.it.model.Supplier;
import nxu.it.model.SupplierPageQueryParam;
import nxu.it.service.SupplierService;
import org.bson.conversions.Bson;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
@ApplicationScoped
public class SupplierServiceMongoImpl implements SupplierService {
    @Inject
    MongoDatabase db;
    @Override
    public Pageable<Supplier> page(SupplierPageQueryParam supplierPageQueryParam) {
        String name = supplierPageQueryParam.getName();
        Bson nameFilter = Filters.empty();
        if (name!=null && !name.isBlank()) {
            nameFilter = Filters.regex("name",
                    String.format(".*%s.*", name), "i");
        }

        MongoCollection<Supplier> supplierCollection = db.getCollection("supplier", Supplier.class);
        long totalRow = supplierCollection.countDocuments(nameFilter);
        int pageSize = supplierPageQueryParam.getPageSize();
        int pageNumber = supplierPageQueryParam.getPageNumber();
        PageUtil.setOneAsFirstPageNo();
        int totalPage = PageUtil.totalPage(totalRow, pageSize);
        int offset = PageUtil.getStart(pageNumber, pageSize);
        ArrayList<Supplier> supplierList = supplierCollection.find(nameFilter)
                .skip(offset).limit(pageSize)
                .into(new ArrayList<>());
        BasePage<Supplier> supplierPage = new BasePage<>(supplierList, pageNumber, pageSize, totalPage, (int) totalRow);
        return supplierPage;
    }
}
