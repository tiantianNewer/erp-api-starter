package nxu.it.api.service.mongo.entity;

public class CategoriesOfProduct {
    protected SimpleCategoryEntity level1;
    protected SimpleCategoryEntity level2;
    protected SimpleCategoryEntity level3;

    public SimpleCategoryEntity getLevel1() {
        return level1;
    }

    public void setLevel1(SimpleCategoryEntity level1) {
        this.level1 = level1;
    }

    public SimpleCategoryEntity getLevel2() {
        return level2;
    }

    public void setLevel2(SimpleCategoryEntity level2) {
        this.level2 = level2;
    }

    public SimpleCategoryEntity getLevel3() {
        return level3;
    }

    public void setLevel3(SimpleCategoryEntity level3) {
        this.level3 = level3;
    }
}
