package nxu.it.api.service.pg.mapper;

import nxu.it.api.service.pg.entity.CategoryEntity;
import nxu.it.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface CategoryMapper {
    Category toCategory(CategoryEntity categoryEntity);
    List<Category> toCategoryList(List<CategoryEntity> categoryEntityList);
}
