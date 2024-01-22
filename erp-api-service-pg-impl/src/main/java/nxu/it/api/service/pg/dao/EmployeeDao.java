package nxu.it.api.service.pg.dao;

import nxu.it.api.service.pg.entity.EmployeeEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import java.util.List;

@Dao
public interface EmployeeDao {
    @Select
    List<EmployeeEntity> page(String name, String gender, String region, String title);
}
