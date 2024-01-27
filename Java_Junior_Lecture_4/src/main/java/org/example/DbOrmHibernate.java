package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.*;
import java.util.List;

public class DbOrmHibernate {

    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static void connectionInsert() {

        /**
         * Вариант dirty code
         */
//        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure()
//                .build();
//        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        Magic magic = new Magic("Волшебная стрела", 10 , 0);
//        session.beginTransaction();
//        session.save(magic);
//        session.getTransaction().commit();
//        session.close();

        /**
         * Вариант cleaner code
         */
        ConnectorOrmHibernate connector = new ConnectorOrmHibernate();
        Session session = connector.getSession();
        Magic magic;
        session.beginTransaction();
        magic = new Magic("Волшебная стрела", 10, 0, 0);
        session.save(magic);
        magic = new Magic("Молния", 25, 0, 0);
        session.save(magic);
        magic = new Magic("Каменная кожа", 0, 0, 6);
        session.save(magic);
        magic = new Magic("Жажда крови", 0, 6, 0);
        session.save(magic);
        magic = new Magic("Жажда крови", 0, 6, 0);
        session.save(magic);
        magic = new Magic("Проклятие", 10, -3, 0);
        session.save(magic);
        magic = new Magic("Лечение", -30, 0, 0);
        session.save(magic);
        session.getTransaction().commit();
        session.close();
    }

    public static void connectionSelect() {
        ConnectorOrmHibernate connector = new ConnectorOrmHibernate();
        try (Session session = connector.getSession()) {
            List<Magic> books = session.createQuery("FROM Magic", Magic.class).getResultList();
            books.stream().forEach(System.out::println);
        }
        ;
    }

    public static void connectionUpdate() {
        ConnectorOrmHibernate connector = new ConnectorOrmHibernate();
        try (Session session = connector.getSession()) {
            Magic magic = session.createQuery("FROM Magic where id = :id", Magic.class)
                    .setParameter("id",4)
                    .getSingleResult();
            System.out.println(magic);
            magic.setAttBonus(100);
            magic.setName("Ярость");
            session.beginTransaction();
            session.update(magic);
            session.getTransaction().commit();
        }
    }

    public static void connectionDelete() {
        ConnectorOrmHibernate connector = new ConnectorOrmHibernate();
        try (Session session = connector.getSession()) {
            session.getTransaction();
            List<Magic> magics = session.createQuery("FROM Magic", Magic.class).getResultList();
            magics.forEach(t -> session.delete(t));
            session.getTransaction().commit();
        }
    }

}
