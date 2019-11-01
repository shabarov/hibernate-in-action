package ru.shabarov.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.shabarov.hibernate.model.Message;
import ru.shabarov.hibernate.util.HibernateUtils;

import java.util.List;

public class Main {

    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String [] args) {
        HibernateUtils.doTransactional(em -> {
            Message message = new Message();
            message.setText("Hello World!");
            em.persist(message);
        });

        HibernateUtils.doTransactional(em -> {
            @SuppressWarnings("unchecked")
            List<Message> messages = em.createQuery("select m from Message m").getResultList();
            logger.info("Messages: " + messages.toString());
        });

        //SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder()
//        .configure("hibernate.cfg.xml").build())
//        .buildMetadata().buildSessionFactory();

    }
}
