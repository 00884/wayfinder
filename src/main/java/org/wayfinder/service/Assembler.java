package org.wayfinder.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wayfinder.entity.UserEntity;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Иван on 13.10.14.
 */
@Service("assmbler")
public class Assembler {

    @Transactional(readOnly = true)
    User buildUserFromUserEntity(UserEntity userEntity){
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        for (String role : userEntity.getRoles().split(",")) {
            role=role.trim();
            authorities.add(new GrantedAuthorityImpl(role));
        }

        User user = new User(userEntity.getUsername(), userEntity.getPassword(), true,
                true, true, true,authorities);
        return user;
    }
}
