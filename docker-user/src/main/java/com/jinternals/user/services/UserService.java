package com.jinternals.user.services;


import com.jinternals.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by mradul on 07/07/17.
 */
public interface UserService {

    User createUser(User user);

    Page<User> getAllUser(Pageable pageable);

    User findById(String id);

}
