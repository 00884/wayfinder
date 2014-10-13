package org.wayfinder.dao;

import org.wayfinder.entity.UserEntity;

/**
 * Created by Иван on 11.10.14.
 */
public interface UserDAO {

    public UserEntity getUser(String login);
    public void addUser(UserEntity user);
    public void updateUser(UserEntity user);
    public void removeUser(String login);

}
