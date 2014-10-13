package org.wayfinder.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

/**
 * Created by Иван on 13.10.14.
 */
public class HibernateUtil{
    private static SessionFactory sessionFactory;

    static{
        sessionFactory= new Configuration().configure(new File("E:\\Projects\\JavaEE\\wayfinder2\\hibernate.cfg.xml"))
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
