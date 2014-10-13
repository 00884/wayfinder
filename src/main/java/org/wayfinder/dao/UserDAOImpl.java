package org.wayfinder.dao;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.wayfinder.entity.UserEntity;

import java.io.File;

/**
 * Created by Иван on 11.10.14.
 */
public class UserDAOImpl implements UserDAO {

    private Session openSession() {
        System.out.println("Начинаем открывать соеденение");
        Session session= new Configuration().configure().buildSessionFactory().openSession();
        System.out.println("Закончили открывать соеденение");
        return session;
    }

    public UserEntity getUser(String login) {
        UserEntity user=(UserEntity)openSession().get(UserEntity.class,login);
        return user;
    }

    @Override
    public void addUser(UserEntity user) {
        openSession().save(user);
        openSession().flush();
    }

    @Override
    public void updateUser(UserEntity user) {
        openSession().update(user);
        openSession().flush();
    }

    @Override
    public void removeUser(String login) {
        openSession().delete(getUser(login));
        openSession().flush();
    }
}
