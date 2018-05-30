package com.jinternals.user.repositories;

import com.jinternals.user.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by mradul on 07/07/17.
 */
public interface UserRepository extends PagingAndSortingRepository<User, String> {

}
