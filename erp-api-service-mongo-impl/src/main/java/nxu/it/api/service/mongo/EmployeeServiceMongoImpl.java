package nxu.it.api.service.mongo;

import cn.hutool.core.util.PageUtil;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import nxu.it.api.common.result.BasePage;
import nxu.it.api.common.result.Pageable;
import nxu.it.model.Employee;
import nxu.it.model.EmployeePageQueryParam;
import nxu.it.service.EmployeeService;
import org.bson.conversions.Bson;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;

@ApplicationScoped
public class EmployeeServiceMongoImpl implements EmployeeService {
    @Inject
    MongoDatabase db;
    
    @Override
    public Pageable<Employee> page(EmployeePageQueryParam employeePageQueryParam) {
        String name = employeePageQueryParam.getName();
        String gender = employeePageQueryParam.getGender();
        String region = employeePageQueryParam.getRegion();
        String title = employeePageQueryParam.getTitle();

        ArrayList<Bson> filterList = new ArrayList<>();
        if (name!=null && !name.isBlank()) {
            Bson nameFilter = Filters.regex("name",
                    String.format(".*%s.*", name), "i");
            filterList.add(nameFilter);
        }
        if (gender!=null && !gender.isBlank()) {
            Bson genderFilter = Filters.regex("gender",
                    String.format(".*%s.*", gender), "i");
            filterList.add(genderFilter);
        }
        if (region!=null && !region.isBlank()) {
            Bson regionFilter = Filters.regex("region",
                    String.format(".*%s.*", region), "i");
            filterList.add(regionFilter);
        }
        if (title!=null && !title.isBlank()) {
            Bson titleFilter = Filters.regex("title",
                    String.format(".*%s.*", title), "i");
            filterList.add(titleFilter);
        }

        MongoCollection<Employee> employeesCollection = db.getCollection("employee", Employee.class);
        Bson allFilters = filterList.isEmpty() ? Filters.empty() : Filters.and(filterList);

        long totalRow = employeesCollection.countDocuments(allFilters);
        int pageSize = employeePageQueryParam.getPageSize();
        int pageNumber = employeePageQueryParam.getPageNumber();
        PageUtil.setOneAsFirstPageNo();
        int totalPage = PageUtil.totalPage(totalRow, pageSize);
        int offset = PageUtil.getStart(pageNumber, pageSize);
        ArrayList<Employee> employeeList = employeesCollection.find(allFilters)
                .skip(offset).limit(pageSize)
                .into(new ArrayList<>());
        BasePage<Employee> employeePage = new BasePage<>(employeeList, pageNumber, pageSize, totalPage, (int) totalRow);
        return employeePage;
    }
}
