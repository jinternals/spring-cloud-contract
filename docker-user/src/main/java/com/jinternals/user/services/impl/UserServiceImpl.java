package com.jinternals.user.services.impl;

import com.cloud.example.user.domain.User;
import com.cloud.example.user.repositories.UserRepository;
import com.cloud.example.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by mradul on 07/07/17.
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private int A =10;
    @PostConstruct
    public void init()
    {
        A = 20;
        System.out.println("PostConstruct called");
    }

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public int getA() {
        return A;
    }
}
