package nxu.it.api.service.pg.mapper;

import nxu.it.api.service.pg.entity.EmployeeEntity;
import nxu.it.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface EmployeeMapper {
    Employee toEmployee(EmployeeEntity employeeEntity);

    List<Employee> toEmployeeList(List<EmployeeEntity> employeeEntityList);
}
