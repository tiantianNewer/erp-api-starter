package nxu.it.service.pg;

import io.quarkus.test.junit.QuarkusTest;
import nxu.it.api.service.pg.CategoryServicePgImpl;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class CategoryTest {
    @Inject
    CategoryServicePgImpl categoryServicePg;

    @Test
    void test_find_by_level() {
        short level = 2; //4,3,2,1,0
        System.out.println(categoryServicePg.findByLevel(level));
    }
}
