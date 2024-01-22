package nxu.it.model;

public class Category {
    protected String id3;
    protected String name3;
    protected String id2;
    protected String name2;
    protected String id1;
    protected String name1;
    protected String parent_id;
    protected Short level;

    public Category() {
    }

    public String getId3() {
        return id3;
    }

    public void setId3(String id3) {
        this.id3 = id3;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id3='" + id3 + '\'' +
                ", name3='" + name3 + '\'' +
                ", id2='" + id2 + '\'' +
                ", name2='" + name2 + '\'' +
                ", id1='" + id1 + '\'' +
                ", name1='" + name1 + '\'' +
                ", parent_id='" + parent_id + '\'' +
                ", level=" + level +
                '}';
    }
}
