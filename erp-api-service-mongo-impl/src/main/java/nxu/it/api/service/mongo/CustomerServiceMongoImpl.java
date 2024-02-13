package nxu.it.api.service.mongo;

import cn.hutool.core.util.PageUtil;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import nxu.it.api.common.result.BasePage;
import nxu.it.api.common.result.Pageable;
import nxu.it.model.Customer;
import nxu.it.model.CustomerPageQueryParam;
import nxu.it.service.CustomerService;
import org.bson.conversions.Bson;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;

@ApplicationScoped
public class CustomerServiceMongoImpl implements CustomerService {
    @Inject
    MongoDatabase db;
    @Override
    public Pageable<Customer> page(CustomerPageQueryParam customerPageQueryParam) {
        String name = customerPageQueryParam.getName();
        String region = customerPageQueryParam.getRegion();
        String province = customerPageQueryParam.getProvince();
        String city = customerPageQueryParam.getCity();

        ArrayList<Bson> filterList = new ArrayList<>();
        if (name!=null && !name.isBlank()) {
            Bson nameFilter = Filters.regex("name",
                    String.format(".*%s.*", name), "i");
            filterList.add(nameFilter);
        }
        if (region!=null && !region.isBlank()) {
            Bson regionFilter = Filters.regex("region",
                    String.format(".*%s.*", region), "i");
            filterList.add(regionFilter);
        }
        if (province!=null && !province.isBlank()) {
            Bson provinceFilter = Filters.regex("province",
                    String.format(".*%s.*", province), "i");
            filterList.add(provinceFilter);
        }
        if (city!=null && !city.isBlank()) {
            Bson cityFilter = Filters.regex("city",
                    String.format(".*%s.*", city), "i");
            filterList.add(cityFilter);
        }

        MongoCollection<Customer> customerCollection = db.getCollection("customer", Customer.class);
        Bson allFilters = filterList.isEmpty() ? Filters.empty() : Filters.and(filterList);

        long totalRow = customerCollection.countDocuments(allFilters);
        int pageSize = customerPageQueryParam.getPageSize();
        int pageNumber = customerPageQueryParam.getPageNumber();
        PageUtil.setOneAsFirstPageNo();
        int totalPage = PageUtil.totalPage(totalRow, pageSize);
        int offset = PageUtil.getStart(pageNumber, pageSize);
        ArrayList<Customer> customerList = customerCollection.find(allFilters)
                .skip(offset).limit(pageSize)
                .into(new ArrayList<>());
        BasePage<Customer> customerPage = new BasePage<>(customerList, pageNumber, pageSize, totalPage, (int) totalRow);
        return customerPage;
    }
}
