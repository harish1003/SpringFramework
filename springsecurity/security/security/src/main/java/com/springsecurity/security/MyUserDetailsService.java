package com.springsecurity.security;

import com.springsecurity.security.model.MyUser;
import com.springsecurity.security.repository.MyUserRepositiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private MyUserRepositiory repositiory;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<MyUser> user = repositiory.findByUserName(userName);
       if(user.isPresent()){
               return User.builder().username(user.get().getUserName())
                       .password(user.get().getPassword())
                       .roles(getRoles(user.get()))
                       .build();
       }
       else{
           throw new UsernameNotFoundException(userName);
       }
    }
    private String[] getRoles(MyUser user) {
        if (user.getRole() == null) {
            return new String[]{"USER"};
        }
        return user.getRole().split(",");
    }


}
