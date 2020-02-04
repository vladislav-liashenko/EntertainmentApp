package com.entertainmentApp.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Entertainment {

    private String name;
    private String description;
    private String address;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    public Entertainment(String name, String description, String address,Date date) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.date=date;

    }

    public Entertainment() { }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
