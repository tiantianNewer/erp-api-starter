package nxu.it.api.service.pg;
import cn.hutool.core.util.PageUtil;
import nxu.it.api.common.result.BasePage;
import nxu.it.api.common.result.Pageable;
import nxu.it.api.service.pg.dao.EmployeeDao;
import nxu.it.api.service.pg.entity.EmployeeEntity;
import nxu.it.api.service.pg.mapper.EmployeeMapper;
import nxu.it.model.Employee;
import nxu.it.model.EmployeePageQueryParam;
import nxu.it.service.EmployeeService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class EmployeeServicePgImpl implements EmployeeService {
    @Inject
    EmployeeDao employeeDao;
    @Inject
    EmployeeMapper employeeMapper;
    @Override
    public Pageable<Employee> page(EmployeePageQueryParam employeePageQueryParam) {
        List<EmployeeEntity> employeeEntityList = employeeDao.page(employeePageQueryParam.getName(), employeePageQueryParam.getGender(),
                employeePageQueryParam.getRegion(), employeePageQueryParam.getTitle());
        List<Employee> employeeList = employeeMapper.toEmployeeList(employeeEntityList);

        int totalRow = employeeList.size();
        int pageSize = employeePageQueryParam.getPageSize();
        int pageNumber = employeePageQueryParam.getPageNumber();
        int totalPage = PageUtil.totalPage(totalRow, pageSize);

        PageUtil.setOneAsFirstPageNo();
        int start = PageUtil.getStart(pageNumber, pageSize);
        int end = Math.min(start + pageSize, totalRow);
        List<Employee> subList = new ArrayList<>();
        if (start < end) {
            subList = employeeList.subList(start, end);
        }
        return new BasePage<>(subList, pageNumber, pageSize, totalPage, totalRow);
    }
}
