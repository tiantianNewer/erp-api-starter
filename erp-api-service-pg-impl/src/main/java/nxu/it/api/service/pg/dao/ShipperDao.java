package nxu.it.api.service.pg.dao;

import nxu.it.api.service.pg.entity.ShipperEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import java.util.List;

@Dao
public interface ShipperDao {
    @Select
    List<ShipperEntity> page(String name);
}
