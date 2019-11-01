package ru.shabarov.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.shabarov.hibernate.model.Item;
import ru.shabarov.hibernate.util.HibernateUtils;

import java.util.Date;

public class Main {

    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String [] args) {
        HibernateUtils.doTransactional((em) -> {
            // Constraint violation:
            Item item = new Item("a", new Date());
            em.persist(item);
        });
    }
}
