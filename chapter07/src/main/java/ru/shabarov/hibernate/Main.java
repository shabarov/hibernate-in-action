package ru.shabarov.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.shabarov.hibernate.model.composition.*;
import ru.shabarov.hibernate.model.manytoone.Bid;
import ru.shabarov.hibernate.model.manytoone.Item6;
import ru.shabarov.hibernate.util.HibernateUtils;

public class Main {
    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String [] args) {

        HibernateUtils.doTransactional((em) -> {

            // Sets mapping
            Item item = new Item();
            item.setName("some name");

            item.getImages().add("filename1");
            item.getImages().add("filename2");

            em.persist(item);
            em.flush();
            em.clear();

            // List mapping
            Item2 item2 = new Item2();
            item2.setName("some name");

            item2.getImages().add("filename1");
            item2.getImages().add("filename2");

            em.persist(item2);

            // Map mapping
            Item3 item3 = new Item3();
            item3.setName("some name");

            item3.getImages().put("filename1", "some name");
            item3.getImages().put("filename2", "some name");

            em.persist(item3);

            // Image object set
            Item5 item5 = new Item5();
            item5.setName("item5");
            item5.getImages().add(new Image("title1", "filename1", 1, 1));
            item5.getImages().add(new Image("title2", "filename2", 2, 2));

            em.persist(item5);
        });

        HibernateUtils.doTransactional(em -> {
            Item itemFetched = (Item) em.createQuery("select i from Item i").getSingleResult();
            logger.info("Image = {}", itemFetched.getImages().iterator().next());

            Item6 item6 = new Item6();
            item6.setName("item6");
            em.persist(item6);

            Bid bid = new Bid();
            bid.setItem(item6);
            bid.setValue(1);

            Bid bid2 = new Bid();
            bid2.setItem(item6);
            bid2.setValue(2);

            item6.getBids().add(bid);
            item6.getBids().add(bid2);

            em.persist(bid);
            em.persist(bid2);
        });

    }
}