package ru.shabarov.hibernate;

import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.jpa.HibernateQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.shabarov.hibernate.model.Item;
import ru.shabarov.hibernate.util.HibernateUtils;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class Main {

    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String [] args) {

        HibernateUtils.doTransactional((em) -> {
            for (int i = 0; i < 100; i++) {
                Item item = new Item("item" + i);
                em.persist(item);
            }

            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Item> criteriaQuery = criteriaBuilder.createQuery(Item.class);
            criteriaQuery.select(criteriaQuery.from(Item.class));

            TypedQuery<Item> itemQuery = em.createQuery(criteriaQuery);
            List<Item> items = itemQuery.getResultList();
            logger.info("Items = {}", items);

            em.flush();
            em.clear();

            Item item = em.createQuery("select i from Item i where i.id = :id", Item.class)
                    .setParameter("id", 1L)
                    .getSingleResult();

//            criteriaQuery.where(criteriaBuilder.equal(criteriaQuery.from(Item.class).get("id"), 2L));
//            itemQuery = em.createQuery(criteriaQuery);
//            item = itemQuery.getSingleResult();

            TypedQuery<Item> itemQuery2 = em.createQuery("select i from Item i", Item.class);
            itemQuery2.setFirstResult(5).setMaxResults(3);
            logger.info("Paginated Item list = {}", itemQuery2.getResultList().size());

            org.hibernate.query.Query query = em.unwrap(Session.class).createQuery("select i from Item i");
            ScrollableResults scroll = query.scroll(ScrollMode.SCROLL_INSENSITIVE);
            scroll.last();
            int count = scroll.getRowNumber() + 1;
            logger.info("Count = {}", count);
            scroll.close();

            query.setFirstResult(9).setMaxResults(1);

            TypedQuery<Item> findItemsByName = em.createNamedQuery("findItemsByName", Item.class);
            List<Item> resultList = findItemsByName.getResultList();
            logger.info("Find by name = {}", resultList);
        });
    }
}