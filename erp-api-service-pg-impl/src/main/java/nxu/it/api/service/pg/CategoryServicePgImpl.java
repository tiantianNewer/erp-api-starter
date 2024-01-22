package nxu.it.api.service.pg;

import nxu.it.api.service.pg.dao.CategoryDao;
import nxu.it.api.service.pg.entity.CategoryEntity;
import nxu.it.api.service.pg.mapper.CategoryMapper;
import nxu.it.model.Category;
import nxu.it.service.CategoryService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.ListIterator;

@ApplicationScoped
public class CategoryServicePgImpl implements CategoryService {
    @Inject
    CategoryDao categoryDao;
    @Inject
    CategoryMapper categoryMapper;
    @Override
    public List<Category> findByLevel(Short level) {
        List<CategoryEntity> categoryEntityList = categoryDao.findByLevel(level);
        List<Category> categoryList = categoryMapper.toCategoryList(categoryEntityList);
        ListIterator<Category> categoryListIterator = categoryList.listIterator();
        while (categoryListIterator.hasNext()) {
            Category category = categoryListIterator.next();
            if (level == 3) {
                category.setId2(category.getId3().substring(0,4));
            } else if (level == 2) {
                category.setId1(category.getId3().substring(0,2));
                category.setId2(category.getId3());
                category.setId3(null);
                category.setName2(category.getName3());
                category.setName3(null);
            } else if (level == 1) {
                category.setId1(category.getId3());
                category.setId3(null);
                category.setName1(category.getName3());
                category.setName3(null);
            }
        }
        return categoryList;
    }
}
