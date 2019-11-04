package ru.shabarov.hibernate.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

public final class HibernateUtils {

    private final static Logger logger = LoggerFactory.getLogger(HibernateUtils.class);

    private final static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("my-persistence-unit");

//    @PersistenceContext(unitName = "my-persistence-unit", type = PersistenceContextType.EXTENDED)
//    private EntityManager entityManager;

    private HibernateUtils() {
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void doTransactional(HibernateAction callback) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            callback.apply(entityManager);
            transaction.commit();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
