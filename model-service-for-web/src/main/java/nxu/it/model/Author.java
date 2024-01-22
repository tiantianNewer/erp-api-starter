package nxu.it.model;

public class Author {

    /**
     * 创建作者
     */
    public Author() {
    }

    /**
     * 创建指定学号和姓名的作者
     */
    public Author(String sno, String name) {
        this.name = name;
        this.sno = sno;
    }

    /**
     * 创建指定学号、姓名、年级和班级的作者
     */
    public Author(String sno, String name, Integer grade, String klass) {
        this(sno, name);
        this.grade = grade;
        this.klass = klass;
    }

    /**
     * 学生姓名
     */

    protected String name;

    /**
     * 学号
     */

    protected String sno;

    /**
     * 班级
     */

    protected String klass;

    /**
     * 年级
     */

    protected Integer grade;

    /**
     * 获取作者姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 获取作者姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取作者学号
     */
    public String getSno() {
        return sno;
    }

    /**
     * 设置作者学号
     */
    public void setSno(String sno) {
        this.sno = sno;
    }

    /**
     * 返回作者班级
     */
    public String getKlass() {
        return klass;
    }

    /**
     * 设置作者班级
     */
    public void setKlass(String klass) {
        this.klass = klass;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}


