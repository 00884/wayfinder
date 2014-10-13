package org.wayfinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wayfinder.dao.UserDAO;
import org.wayfinder.entity.UserEntity;

/**
 * Created by Иван on 13.10.14.
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO dao;
    @Autowired
    private Assembler assembler;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
        System.out.println("!!!");

        UserEntity userEntity=null;
        try{
            userEntity=dao.getUser(username);
        }
        catch (Throwable e){
            e.printStackTrace();
        }
        System.out.println("!!!");

        if (userEntity == null){
            System.out.println("(((");
            throw new UsernameNotFoundException("user not found");
        }
        System.out.println("!!!");

        User u=assembler.buildUserFromUserEntity(userEntity);
        System.out.println("!!!");
        System.out.println(u.getUsername()+u.getPassword());
        return u;
    }
}