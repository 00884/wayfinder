package org.wayfinder.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Иван on 13.10.14.
 */
public class HibernateUtil{

    private static SessionFactory sessionFactory;

    static{
        try {
            Configuration c=new Configuration().configure(new File("hibernate.cfg.xml"));
            c.buildSessionFactory();
            sessionFactory=c.buildSessionFactory();
        } catch (ExceptionInInitializerError e) {
            System.out.println("Initial SessionFactory creation failed: "+e);
            throw  new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
