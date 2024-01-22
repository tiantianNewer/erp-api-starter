package nxu.it.service;

import nxu.it.api.common.result.Pageable;
import nxu.it.model.Employee;
import nxu.it.model.EmployeePageQueryParam;

public interface EmployeeService {
    /**
     * 根据name 姓名、gender 性别、region 负责地区、title 职位获得员工信息
     *
     * @param employeePageQueryParam 分页查询条件
     * @return 分页显示员工信息
     */
    Pageable<Employee> page(EmployeePageQueryParam employeePageQueryParam);
}
