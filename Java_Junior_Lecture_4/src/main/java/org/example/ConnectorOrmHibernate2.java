package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectorOrmHibernate2 {
    SessionFactory sessionFactory;

    public ConnectorOrmHibernate2() {
        sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
