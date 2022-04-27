package com.test.hospital.dao;

import javax.persistence.*;
import java.util.*;

@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "uuid")
    private UUID UUID;

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

    public UUID getUuid() {
        return UUID;
    }

    public void setUuid(UUID uuid) {
        this.UUID = uuid;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    @Column(name = "registration_date")
    private Date registration_date;

}

