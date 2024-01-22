package nxu.it.service;

import nxu.it.model.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 根据level 产品类型的等级查询本级及上级类型
     * @param level 产品类型的等级
     * @return 指定等级的产品类型
     */
    List<Category> findByLevel(Short level);
}
