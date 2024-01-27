package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        User user = new User();
        user.setName("Igor");

        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            System.out.println(user); //User(id=null, name=Igor)
            System.out.println(session.save(user));
            System.out.println(user); //User(id=1, name=Igor)
            session.getTransaction().commit();
        }

        try(Session session = sessionFactory.openSession()){
            List<User> resultList = session.createQuery("select u from User u where u.id = 1", User.class)
                    .getResultList();
            System.out.println(resultList);
            User userLoaded = session.get(User.class,1);
            System.out.println(userLoaded);
        }



        sessionFactory.close();
    }
}