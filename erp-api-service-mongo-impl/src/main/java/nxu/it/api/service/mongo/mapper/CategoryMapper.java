package nxu.it.api.service.mongo.mapper;

import nxu.it.api.service.mongo.entity.SimpleCategoryEntity;
import nxu.it.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface CategoryMapper {
    default Category toCategory(SimpleCategoryEntity simpleCategoryEntity) {
        if (simpleCategoryEntity == null) {
            return null;
        }
        Category category = new Category();
        Integer idTemp = simpleCategoryEntity.getId();
        if (idTemp != null) {
            String id = idTemp.toString();
            int length = id.length();
            if (length % 2 == 1) { //奇数
                id = "0" + id;
                length++;
            }
            if (length == 2) {
                category.setId1(id);
                category.setName1(simpleCategoryEntity.getName());
            } else if (length == 4) {
                category.setId2(id);
                category.setParentId(id.substring(2));
                category.setName2(simpleCategoryEntity.getName());
            } else if (6 == length) {
                category.setId3(id);
                category.setParentId(id.substring(2));
                category.setName3(simpleCategoryEntity.getName());
            }
        }
        Integer level = simpleCategoryEntity.getLevel();
        if (level != null) {
            category.setLevel(level.shortValue());
        }
        return category;
    }

    List<Category> toCategoryList(List<SimpleCategoryEntity> simpleCategoryEntityList);
}
