package ru.shabarov.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.shabarov.hibernate.model.Bid;
import ru.shabarov.hibernate.model.Item;
import ru.shabarov.hibernate.model.ItemBidSummary;
import ru.shabarov.hibernate.util.HibernateUtils;

import java.util.Date;

public class Main {
    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String [] args) {

        HibernateUtils.doTransactional((em) -> {
            Item item = new Item();
            item.setDate(new Date());
            item.setName("item1");
            em.persist(item);

            Bid bid = new Bid();
            bid.setItemId(item.getId());
            bid.setValue("Bid1");
            em.persist(bid);

            item = new Item();
            item.setDate(new Date());
            item.setName("item2");
            em.persist(item);

            bid = new Bid();
            bid.setItemId(item.getId());
            bid.setValue("Bid2");
            em.persist(bid);

            bid = new Bid();
            bid.setItemId(item.getId());
            bid.setValue("Bid3");
            em.persist(bid);
            em.flush();

            ItemBidSummary itemBidSummary = em.find(ItemBidSummary.class, item.getId());

            assert(itemBidSummary != null && itemBidSummary.getItemId() != 0);
        });
    }
}