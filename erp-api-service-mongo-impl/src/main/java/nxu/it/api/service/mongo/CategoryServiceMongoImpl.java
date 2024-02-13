package nxu.it.api.service.mongo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import nxu.it.api.service.mongo.entity.SimpleCategoryEntity;
import nxu.it.api.service.mongo.mapper.CategoryMapper;
import nxu.it.model.Category;
import nxu.it.service.CategoryService;
import org.bson.conversions.Bson;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
public class CategoryServiceMongoImpl implements CategoryService {
    @Inject
    MongoDatabase db;
    @Inject
    CategoryMapper categoryMapper;
    @Override
    public List<Category> findByLevel(Short level) {
        Bson levelFilter = Filters.eq("level", level);
        MongoCollection<SimpleCategoryEntity> categoryCollection = db.getCollection("category", SimpleCategoryEntity.class);
        ArrayList<SimpleCategoryEntity> simpleCategoryEntityList = categoryCollection.find(levelFilter).into(new ArrayList<>());
        List<Category> categoryList = categoryMapper.toCategoryList(simpleCategoryEntityList);
        return categoryList;
    }
}
