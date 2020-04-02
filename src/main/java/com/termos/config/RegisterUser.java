package com.termos.config;

import com.termos.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RegisterUser {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User register;


}
