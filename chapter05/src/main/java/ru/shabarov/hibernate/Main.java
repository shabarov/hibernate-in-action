package ru.shabarov.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.shabarov.hibernate.model.Address;
import ru.shabarov.hibernate.model.MyEntity;
import ru.shabarov.hibernate.model.User;
import ru.shabarov.hibernate.util.HibernateUtils;

import java.util.List;

public class Main {
    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String [] args) {

        HibernateUtils.doTransactional((em) -> {
            MyEntity myEntity = new MyEntity();
            myEntity.setDescription("Some entity");
            myEntity.setMetricWeight(2.0);
            em.persist(myEntity);

            Address address = new Address();
            address.setCity("Moscow");

            Address billingAddress = new Address();
            billingAddress.setCity("Korolev");

            User user = new User();
            user.setAddress(address);
            user.setBillingAddress(billingAddress);

            em.persist(user);
        });

        HibernateUtils.doTransactional(em -> {
            MyEntity some_entity = em.find(MyEntity.class, "Some entity");
            logger.info("Some entity = {}", some_entity);
        });
    }
}