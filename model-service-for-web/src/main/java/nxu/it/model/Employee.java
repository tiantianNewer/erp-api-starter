package nxu.it.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Employee {
    protected String id;
    protected String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    protected LocalDate birthDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    protected LocalDate hireDate;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
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
                ", birthDate=" + birthDate +
                ", hireDate=" + hireDate +
                ", title='" + title + '\'' +
                ", region='" + region + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
