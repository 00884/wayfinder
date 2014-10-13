package org.wayfinder.service;

import org.wayfinder.entity.UserEntity;

/**
 * Created by Иван on 12.10.14.
 */
public interface UserService {
    public void addUser(UserEntity user);
    public void removeUser(String login);
    public UserEntity getUser(String login);
    public void updateUser(UserEntity user);
}
