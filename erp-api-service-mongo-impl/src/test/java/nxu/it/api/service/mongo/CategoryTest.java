package nxu.it.api.service.mongo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class CategoryTest {
    @Inject
    CategoryServiceMongoImpl categoryServiceMongo;

    @Test
    void test_find_by_level() {
        short level = 2; //4,3,2,1,0
        System.out.println(categoryServiceMongo.findByLevel(level));
    }
}
