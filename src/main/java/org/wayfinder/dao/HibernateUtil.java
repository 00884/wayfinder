package org.wayfinder.dao;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.io.File;

/**
 * Created by Иван on 13.10.14.
 */
public class HibernateUtil{
    private static Session session;

    static{
        System.out.println("Начинаем открывать соеденение");
        session= new Configuration().configure(new File("hibernate.cfg.xml")).buildSessionFactory().openSession();
        System.out.println("Закончили открывать соеденение");
    }

    public static Session getSession() {
        return session;
    }
}
