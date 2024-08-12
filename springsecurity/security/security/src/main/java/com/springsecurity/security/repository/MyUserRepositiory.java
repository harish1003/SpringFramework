package com.springsecurity.security.repository;

import com.springsecurity.security.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MyUserRepositiory extends JpaRepository<MyUser,Long> {


     Optional<MyUser> findByUserName(String userName);
}
