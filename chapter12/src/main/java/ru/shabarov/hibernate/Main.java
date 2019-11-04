package ru.shabarov.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.shabarov.hibernate.model.Item;
import ru.shabarov.hibernate.model.User;
import ru.shabarov.hibernate.util.HibernateUtils;

import java.util.List;

public class Main {

    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String [] args) {

        HibernateUtils.doTransactional((em) -> {
            // If lazy init is disabled
//            User user = em.getReference(User.class, 1L);
//            assert !user.getClass().equals(User.class);
//            Class userClass = HibernateProxyHelper.getClassWithoutInitializingProxy(user);
//            assert userClass.equals(User.class);
//            assert !Persistence.getPersistenceUtil().isLoaded(user);

            //Hibernate.initialize(user);

            User john = new User("John");
            em.persist(john);
        });

        HibernateUtils.doTransactional(em -> {
            // If lazy init is enabled then username is not initialized
            User user = em.find(User.class, 1L);

            User sam = new User("Sam");
            User joe = new User("Joe");
            User peter = new User("Peter");
            Item item1 = new Item();
            item1.setUser(sam);
            Item item2 = new Item();
            item2.setUser(joe);
            Item item3 = new Item();
            item3.setUser(peter);

            em.persist(sam);
            em.persist(joe);
            em.persist(peter);
            em.persist(item1);
            em.persist(item2);
            em.persist(item3);
        });

        HibernateUtils.doTransactional(em -> {
            List<Item> items = em.createQuery("select i from Item i").getResultList();
            for (Item i : items) {
//                select user0_.id as id1_1_0_, user0_.username as username2_1_0_
//                from USERS user0_
//                where user0_.id in ( ?, ?, ?)
                String username = i.getUser().getUsername();
            }
        });

    }
}