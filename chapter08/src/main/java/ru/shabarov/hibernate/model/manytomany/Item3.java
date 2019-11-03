package ru.shabarov.hibernate.model.manytomany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item3 {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany(mappedBy = "item")
    protected Set<CategorizedItem> categorizedItems = new HashSet<>();


    public Item3() {
    }

    public Item3(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<CategorizedItem> getCategorizedItems() {
        return categorizedItems;
    }

    public void setCategorizedItems(Set<CategorizedItem> categorizedItems) {
        this.categorizedItems = categorizedItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categorizedItems=" + categorizedItems +
                '}';
    }
}
