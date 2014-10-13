package org.wayfinder.dao;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.wayfinder.entity.UserEntity;

import java.io.File;

/**
 * Created by Иван on 11.10.14.
 */
@Repository
public class UserDAOImpl implements UserDAO {

    private Session openSession() {
        Session session=HibernateUtil.getSessionFactory().openSession();
        return session;
    }

    @Transactional
    @Override
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
