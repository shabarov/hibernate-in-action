package ru.shabarov.hibernate.model.composition;

import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import java.util.SortedMap;
import java.util.TreeMap;

@Entity
public class Item4 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    protected Long id;

    @Column(name = "ITEM_NAME", nullable = false)
    protected String name;

    @ElementCollection
    @CollectionTable(name = "IMAGE4")
    @MapKeyColumn(name = "FILENAME")
    @SortNatural
    @Column(name = "IMAGENAME")
    protected SortedMap<String, String> images = new TreeMap<>();

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

    public SortedMap<String, String> getImages() {
        return images;
    }

    public void setImages(SortedMap<String, String> images) {
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
