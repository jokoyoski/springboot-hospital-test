package com.test.hospital.dto;

import javax.persistence.Column;
import java.util.*;

public class Patient {
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "last_visit_date")
    private Date last_visit_date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getLast_visit_date() {
        return last_visit_date;
    }

    public void setLast_visit_date(Date last_visit_date) {
        this.last_visit_date = last_visit_date;
    }


}
