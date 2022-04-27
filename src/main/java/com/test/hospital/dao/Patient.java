package com.test.hospital.dao;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.*;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private Integer age;

    private Date last_visit_date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    @Column(name = "last_visit_date")
    public Date getLast_visit_date() {
        return last_visit_date;
    }

    public void setLast_visit_date(Date last_visit_date) {
        this.last_visit_date = last_visit_date;
    }


}
