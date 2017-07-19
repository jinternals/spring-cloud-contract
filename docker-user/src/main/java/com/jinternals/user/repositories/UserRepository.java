package com.jinternals.user.repositories;

import com.jinternals.user.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by mradul on 07/07/17.
 */
public interface UserRepository extends MongoRepository<User, String> {

}
