package com.springsecurity.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class springsecurityx  {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                request -> {
                    request.requestMatchers("/home/**","/createUser/**").permitAll();
                    request.requestMatchers("/admin/**").hasRole("ADMIN");
                    request.requestMatchers(("/user/**")).hasRole("USER");
                    request.anyRequest().authenticated(); // all request which are not with above will be unauthorized
                })
                .formLogin(forml -> forml.permitAll())
                .build();
     }

     /*@Bean
     public UserDetailsService userDetailsSer(){

         UserDetails normalUser = User.builder().username("user").password("$2a$12$uGpvrLVLTuTq8Mmam1tFf.11LQXK.LWWx2wYg8FXBxauW/aM.2H4u").roles("USER").build();
         UserDetails adminUser = User.builder().username("admin").password("$2a$12$QMAdxGzeBwRPivi/67cExOzXfpDEduS9z9AZT2hmUIz5aPJBiDXf2").roles("ADMIN","USER").build();

         return new InMemoryUserDetailsManager(normalUser,adminUser);

     }*/
     @Bean
     public UserDetailsService userDetailsService() {
         return myUserDetailsService;
     }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(myUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

     @Bean
     public PasswordEncoder passwordEncoder(){
         return new BCryptPasswordEncoder();
     }




}
