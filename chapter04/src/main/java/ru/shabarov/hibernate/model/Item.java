package ru.shabarov.hibernate.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ITEM")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    protected Long id;

    @Column(name = "ITEM_NAME", nullable = false)
    protected String name;

    @Column(name = "ITEM_DATE", nullable = false)
    protected Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }
}
