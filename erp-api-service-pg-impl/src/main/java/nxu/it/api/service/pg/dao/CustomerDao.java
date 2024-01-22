package nxu.it.api.service.pg.dao;

import nxu.it.api.service.pg.entity.CustomerEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import java.util.List;

@Dao
public interface CustomerDao {
    @Select
    List<CustomerEntity> page(String name, String region, String province, String city);
}
