package com.entertainmentApp.domain.entertainment;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    private List<Entertainment> entertainments;

    public Category() {
    }

    public Category(final String name) {
        this.name = name;
    }

    public List<Entertainment> getEntertainments() {
        return entertainments;
    }

    public void setEntertainments(final List<Entertainment> entertainments) {
        this.entertainments = entertainments;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
