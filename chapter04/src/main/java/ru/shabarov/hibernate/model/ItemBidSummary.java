package ru.shabarov.hibernate.model;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Immutable
@Subselect(value = "select i.ID as ITEMID, i.ITEM_NAME as NAME, count(b.ID) as NUMBEROFBIDS " +
        "from ITEM i left outer join BID b on i.ID = b.ITEM_ID group by i.ID, i.ITEM_NAME")
@Synchronize({"Item", "Bid"})
public class ItemBidSummary {

    @Id
    protected long itemId;

    protected String name;

    protected long numberOfBids;

    public ItemBidSummary() {
    }

    public long getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public long getNumberOfBids() {
        return numberOfBids;
    }

    @Override
    public String toString() {
        return "ItemBidSummary{" +
                "itemId=" + itemId +
                ", name='" + name + '\'' +
                ", numberOfBids=" + numberOfBids +
                '}';
    }
}
