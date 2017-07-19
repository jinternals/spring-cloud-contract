package com.jinternals.user.services;


import com.jinternals.user.domain.User;

import java.util.List;

/**
 * Created by mradul on 07/07/17.
 */
public interface UserService {

    User createUser(User user);

    List<User> getAllUser();

}
