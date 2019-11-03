package ru.shabarov.hibernate.model.composition;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item2 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    protected Long id;

    @Column(name = "ITEM_NAME", nullable = false)
    protected String name;

    @ElementCollection
    @CollectionTable(name = "IMAGE2")
    @OrderColumn
    @Column(name = "FILENAME")
    protected List<String> images = new ArrayList<>();

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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", images=" + images +
                '}';
    }
}
