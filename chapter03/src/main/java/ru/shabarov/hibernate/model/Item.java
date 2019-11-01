package ru.shabarov.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
public class Item {

    @Id
    @GeneratedValue
    protected Long id;

    @NotNull
    @Size(min = 2, max = 255, message = "Name is required, maximum 255 chars")
    protected String name;

    @Future
    protected Date date;

    public Item() {
    }

    public Item(String name, Date date) {
        this.name = name;
        this.date = date;
    }

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
