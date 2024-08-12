package com.springsecurity.security;


import com.springsecurity.security.model.MyUser;
import com.springsecurity.security.repository.MyUserRepositiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    public MyUserRepositiory myUserRepositiory;

    @GetMapping("/user")
    String getUsersPage(){
        return "user_home";
    }

    @GetMapping("/admin/user")
    String getAdminPage(){
        return "admin_home";
    }

    @GetMapping("/home/user")
    String getHomePage(){
        return "home";
    }

    @PostMapping("/createUser")
    void createUser(@RequestBody MyUser myUser){
        myUser.setPassword(new BCryptPasswordEncoder().encode(myUser.getPassword()));
        System.out.print(myUser.toString());
        myUserRepositiory.save(myUser);
    }



}
