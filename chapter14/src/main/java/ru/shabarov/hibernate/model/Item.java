package ru.shabarov.hibernate.model;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "findItemsByName",
                query = "select i from Item i where i.name like 'item1%'"
        )
})
@Entity
public class Item {

    @Id
    @GeneratedValue
    protected Long id;

    protected String name;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
