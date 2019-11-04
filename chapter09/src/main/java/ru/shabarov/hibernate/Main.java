package ru.shabarov.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.shabarov.hibernate.model.User;
import ru.shabarov.hibernate.util.HibernateUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String [] args) {

        HibernateUtils.doTransactional((em) -> {
            @SuppressWarnings("unchecked")
            List<Object[]> resultList = em.createNativeQuery("select * from Persons").getResultList();
            Object[] res = resultList.iterator().next();
            logger.info("id={}, fn={}, ln={}, age={}", res[0], res[1], res[2], res[3]);

            Calendar auctionEnd = Calendar.getInstance();
            auctionEnd.add(Calendar.HOUR, 1);

            User mike = new User("Mike", "mike@mail.com", new Date(), auctionEnd.getTime());
            em.persist(mike);
        });

        HibernateUtils.doTransactional(em -> {
            em.createNativeQuery("insert into Persons (ID, LastName, FirstName, Age) values (2, 'John', 'A', 20)")
                    .executeUpdate();
        });
    }
}