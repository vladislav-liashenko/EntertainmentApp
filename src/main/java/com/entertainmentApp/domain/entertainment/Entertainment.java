package com.entertainmentApp.domain.entertainment;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "entertainments")
public class Entertainment implements Serializable {

    private String name;

    private String description;

    private String address;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fileName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    public Entertainment(final String name, final String description, final String address,
                         final Date date) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.date = date;
    }

    public Entertainment() {
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }


    @Override
    public String toString() {
        return "Entertainment [" + " id=" + id + ". " +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", date=" + date + "]";
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Entertainment that = (Entertainment) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(address, that.address) &&
                Objects.equals(date, that.date) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, address, date, id);
    }

}
