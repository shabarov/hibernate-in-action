package ru.shabarov.hibernate.model.manytoone;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item6 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    protected Long id;

    @Column(name = "ITEM_NAME", nullable = false)
    protected String name;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
//    @OneToMany(mappedBy = "item", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    protected Set<Bid> bids = new HashSet<>();

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

    public Set<Bid> getBids() {
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }

    @Override
    public String toString() {
        return "Item6{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bids=" + bids +
                '}';
    }
}
