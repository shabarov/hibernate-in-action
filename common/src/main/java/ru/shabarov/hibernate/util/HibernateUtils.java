package ru.shabarov.hibernate.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class HibernateUtils {

    private final static Logger logger = LoggerFactory.getLogger(HibernateUtils.class);

    private HibernateUtils() {

    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    public static void doTransactional(HibernateAction callback) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            callback.apply(entityManager);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            if (entityManager != null) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException(e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
