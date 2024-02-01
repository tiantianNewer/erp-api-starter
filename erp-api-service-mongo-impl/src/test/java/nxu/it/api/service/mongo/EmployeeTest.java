/*
package nxu.it.api.service.mongo;

import io.quarkus.test.junit.QuarkusTest;
import nxu.it.api.common.result.Pageable;
import nxu.it.api.service.pg.EmployeeServicePgImpl;
import nxu.it.model.Employee;
import nxu.it.model.EmployeePageQueryParam;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class EmployeeTest {
    @Inject
    EmployeeServicePgImpl employeeServicePg;
    @Test
    void test_page() {
        EmployeePageQueryParam employeePageQueryParam = new EmployeePageQueryParam();
        employeePageQueryParam.setPageSize(5);
        employeePageQueryParam.setPageNumber(1);

        employeePageQueryParam.setName("马");
        employeePageQueryParam.setGender("男");
        employeePageQueryParam.setRegion("北");
        employeePageQueryParam.setTitle("代表");

        Pageable<Employee> employeePageable = employeeServicePg.page(employeePageQueryParam);
        System.out.println(employeePageable.getList());
    }
}
*/
