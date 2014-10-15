package org.wayfinder.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.wayfinder.dao.UserDAO;
import org.wayfinder.entity.UserEntity;

/**
 * Created by Иван on 11.10.14.
 */
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public UserEntity getUser(String login) {
        UserEntity user=(UserEntity)openSession().get(UserEntity.class,login);
        return user;
    }

    @Transactional
    public void addUser(UserEntity user) {
        openSession().save(user);
        openSession().flush();
    }

    @Transactional
    public void updateUser(UserEntity user) {
        openSession().update(user);
        openSession().flush();
    }

    @Transactional
    public void removeUser(String login) {
        openSession().delete(getUser(login));
        openSession().flush();
    }
}
