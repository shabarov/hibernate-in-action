package ru.shabarov.hibernate.util;

import javax.persistence.EntityManager;

@FunctionalInterface
public interface HibernateAction {
    void apply(EntityManager entityManager);
}
