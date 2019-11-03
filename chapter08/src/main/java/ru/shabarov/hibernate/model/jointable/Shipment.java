package ru.shabarov.hibernate.model.jointable;

import javax.persistence.*;

@Entity
public class Shipment {

    @Id
    @GeneratedValue
    protected Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "ITEM_SHIPMENT",
            joinColumns =
                    @JoinColumn(name = "SHIPMENT_ID"),
            inverseJoinColumns =
                    @JoinColumn(name = "ITEM_ID", nullable = false, unique = true)
    )
    protected Item item;

    protected String value;

    public Shipment() {
    }

    public Shipment(Item item) {
    }

    public Shipment(Item item, String value) {
        this.item = item;
        this.value = value;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "id='" + id + '\'' +
                ", item=" + item +
                ", value='" + value + '\'' +
                '}';
    }
}
