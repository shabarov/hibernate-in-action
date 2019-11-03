package ru.shabarov.hibernate.model.composition;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item5 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    protected Long id;

    @Column(name = "ITEM_NAME", nullable = false)
    protected String name;

    @ElementCollection
    @CollectionTable(name = "IMAGE5")
    @AttributeOverride(name = "filename", column = @Column(name = "FNAME", nullable = false))
    protected Set<Image> images = new HashSet<>();
//    @OrderBy
//    protected Set<Image> images = new LinkedHashSet<>();

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

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
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
