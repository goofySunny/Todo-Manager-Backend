package com.MeowerTech.Meower.BasicAuth;

//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable() // Disable CSRF protection
//                .authorizeRequests()
//                .antMatchers("/public/**").permitAll() // Permit access to public endpoints
//                .anyRequest().authenticated() // Require authentication for all other requests
//                .and()
//                .formLogin(); // Enable form-based authentication
//    }
//}