package com.termos.config;

import com.termos.model.User;
import com.termos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceinterface{

    @Autowired
    private UserRepository repository;

    @Override
    public User registerNewUserAccount(UserDTO accountDto)
    {
        return null;

    }

}
