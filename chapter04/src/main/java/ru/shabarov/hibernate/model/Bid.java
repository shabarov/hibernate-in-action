package ru.shabarov.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "BID")
public class Bid {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    protected long id;

    @Column(name = "ITEM_ID")
    protected long itemId;

    @Column(name = "VALUE")
    protected String value;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
