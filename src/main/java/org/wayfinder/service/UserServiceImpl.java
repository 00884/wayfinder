package org.wayfinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wayfinder.dao.UserDAO;
import org.wayfinder.entity.UserEntity;

/**
 * Created by Иван on 12.10.14.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public void addUser(UserEntity user) {
        userDAO.addUser(user);
    }

    @Transactional
    @Override
    public void removeUser(String login) {
        userDAO.removeUser(login);
    }

    @Transactional
    @Override
    public UserEntity getUser(String login) {
        return userDAO.getUser(login);
    }

    @Transactional
    @Override
    public void updateUser(UserEntity user) {
        userDAO.updateUser(user);
    }
}
