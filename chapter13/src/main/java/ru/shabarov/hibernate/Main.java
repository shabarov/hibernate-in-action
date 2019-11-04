package ru.shabarov.hibernate;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.shabarov.hibernate.model.User;
import ru.shabarov.hibernate.util.HibernateUtils;

import java.util.List;

public class Main {

    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String [] args) {

        HibernateUtils.doTransactional((em) -> {
            Filter limitByUserRankFilter = em.unwrap(Session.class).enableFilter("limitByUserRank");
            limitByUserRankFilter.setParameter("maxUserRank", 1);
            em.persist(new User("Mike", 0));
            em.persist(new User("Joe", 1));
            em.persist(new User("Sam", 2));
            em.persist(new User("Ed", 3));

            em.flush();
            em.clear();

            List<User> users = em.createQuery("select u from User u").getResultList();
            logger.info("Users by rank = {}", users);
        });
    }
}