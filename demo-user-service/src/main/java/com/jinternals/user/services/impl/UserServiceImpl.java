package com.jinternals.user.services.impl;

import com.jinternals.user.domain.User;
import com.jinternals.user.repositories.UserRepository;
import com.jinternals.user.services.IdentityGenerator;
import com.jinternals.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by mradul on 07/07/17.
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private IdentityGenerator identityGenerator;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, IdentityGenerator identityGenerator) {
        this.userRepository = userRepository;
        this.identityGenerator = identityGenerator;
    }

    @Override
    public User createUser(User user) {
        user.setId(identityGenerator.generateIdentity());
        return userRepository.save(user);
    }

    @Override
    public Page<User> getAllUser(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User findById(String email) {
        return userRepository.findByEmail(email);
    }


}
