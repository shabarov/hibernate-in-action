package ru.shabarov.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.shabarov.hibernate.model.Address;
import ru.shabarov.hibernate.model.User;
import ru.shabarov.hibernate.model.jointable.Item;
import ru.shabarov.hibernate.model.jointable.Shipment;
import ru.shabarov.hibernate.model.manytomany.*;
import ru.shabarov.hibernate.util.HibernateUtils;

public class Main {
    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String [] args) {

        HibernateUtils.doTransactional((em) -> {
            Address address = new Address("Some city");
            em.persist(address);

            User mike = new User(address.getId(), "Mike");
            em.persist(mike);

            Shipment shipment = new Shipment();
            em.persist(shipment);

            Item item = new Item("item");
            em.persist(item);

            Shipment shipment2 = new Shipment(item);
            em.persist(shipment2);
        });

        HibernateUtils.doTransactional(em -> {
            User user = em.find(User.class, 1L);
            logger.info("User = {}", user);

            // Many to Many
            Category category = new Category("Category");
            Category other_category = new Category("Other Category");

            Item2 item1 = new Item2("Item");
            Item2 other_item = new Item2("Other item");

            item1.getCategories().add(category);
            item1.getCategories().add(other_category);

            category.getItems().add(item1);
            category.getItems().add(other_item);

            em.persist(category);
            em.persist(other_category);

            // Join entity
            Category2 category2 = new Category2("Category");
            Category2 other_category2 = new Category2("Other Category");
            em.persist(category2);
            em.persist(other_category2);

            Item3 item3 = new Item3("Item");
            Item3 other_item2 = new Item3("Other item");
            em.persist(item3);
            em.persist(other_item2);

            CategorizedItem link1 = new CategorizedItem("john", category2, item3);
            CategorizedItem link2 = new CategorizedItem("mike", category2, other_item2);
            CategorizedItem link3 = new CategorizedItem("mike2", other_category2, item3);

            em.persist(link1);
            em.persist(link2);
            em.persist(link3);
        });
    }
}