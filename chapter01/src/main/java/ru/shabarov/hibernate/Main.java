package ru.shabarov.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.shabarov.hibernate.model.Person;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            persist(sessionFactory);
            load(sessionFactory);
        }
    }

    private static void load(SessionFactory sessionFactory) {
        System.out.println("-- loading persons --");
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Person> persons = session.createQuery("FROM Person").list();
        persons.forEach((x) -> System.out.printf("- %s%n", x));
        session.close();
    }

    private static void persist(SessionFactory sessionFactory) {
        Person p1 = new Person("John", 35);
        Person p2 = new Person("Tina", 30);
        System.out.println("-- persisting persons --");
        System.out.printf("- %s%n- %s%n", p1, p2);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(p1);
        session.save(p2);
        session.getTransaction().commit();
    }
}