package com.termos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class WebSecurityConfigurerAdapterT extends WebSecurityConfigurerAdapter {

    @Autowired
    public DataSource dataSource;

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password(encoder().encode("$2y$12$81/FXXlZ2APcBseoSKii3unqGEW8VQKzgGcIanMC9Y49Um9TKHhtq")).roles("USER")                .and()
                .withUser("admin").password("password1").roles("ADMIN");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/books").hasAnyRole("USER", "ADMIN")
                .antMatchers("/books/{id}").hasRole("USER")
                .antMatchers("/books/{id}").hasRole("ADMIN")
                .antMatchers("/orders").hasRole("USER")
                .antMatchers("/orders").hasRole("ADMIN")
                .antMatchers("/orders/{id}").hasRole("ADMIN")
                .antMatchers("/orders/{id}").hasRole("USER")
                .and()
                .httpBasic(); }


    @Bean
    public PasswordEncoder encoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return charSequence.toString().equals(s);
            }

        };
    }


}