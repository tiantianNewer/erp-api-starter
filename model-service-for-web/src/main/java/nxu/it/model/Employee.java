package nxu.it.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Employee {
    protected String id;
    protected String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    protected LocalDate birth_date;
    @JsonFormat(pattern = "yyyy-MM-dd")
    protected LocalDate hire_date;
    protected String title;
    protected String region;
    protected String phone;

    public Employee() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public LocalDate getHire_date() {
        return hire_date;
    }

    public void setHire_date(LocalDate hire_date) {
        this.hire_date = hire_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birth_date=" + birth_date +
                ", hire_date=" + hire_date +
                ", title='" + title + '\'' +
                ", region='" + region + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
