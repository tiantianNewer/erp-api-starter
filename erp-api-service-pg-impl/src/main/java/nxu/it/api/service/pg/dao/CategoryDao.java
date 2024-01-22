package nxu.it.api.service.pg.dao;

import nxu.it.api.service.pg.entity.CategoryEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import java.util.List;

@Dao
public interface CategoryDao {
    @Select
    List<CategoryEntity> findByLevel(Short level);
}
