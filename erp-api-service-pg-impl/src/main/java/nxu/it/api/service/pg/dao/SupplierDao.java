package nxu.it.api.service.pg.dao;

import nxu.it.api.service.pg.entity.SupplierEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import java.util.List;

@Dao
public interface SupplierDao {
    @Select
    List<SupplierEntity> page(String name);
}
