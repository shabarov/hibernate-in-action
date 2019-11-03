package ru.shabarov.hibernate.model.manytoone;

import javax.persistence.*;

@Entity
public class Bid {

    @Id
    @GeneratedValue
    protected long id;

    @Column(name = "VALUE")
    protected int value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID", nullable = false)
    protected Item6 item;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Item6 getItem() {
        return item;
    }

    public void setItem(Item6 item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id +
                ", value=" + value +
                ", item=" + item +
                '}';
    }
}
