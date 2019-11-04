package ru.shabarov.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.shabarov.hibernate.model.User;
import ru.shabarov.hibernate.util.HibernateUtils;

public class Main {

    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String [] args) {

        HibernateUtils.doTransactional((em) -> {
            User mike = new User("Mike");
            em.persist(mike);

            Long mikeId = mike.getId();
            assert mikeId != null;

            mike.setUsername("John");
            User mikeCopy = em.find(User.class, mikeId);
            assert mikeCopy.getUsername().equals("John");
            assert mike == mikeCopy;
            assert mike.equals(mikeCopy);

            em.flush();
            em.clear();

            User user = em.find(User.class, mikeId);

            assert user.getUsername().equals("John");

            em.remove(user);
            assert !em.contains(user);
            // hibernate.user_identifier_rollback = false
            assert user.getId() != null;

            em.persist(user);
            assert em.contains(user);

            em.detach(user);
            assert !em.contains(user);
        });
    }
}