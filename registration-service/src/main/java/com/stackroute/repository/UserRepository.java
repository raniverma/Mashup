package com.stackroute.repository;

import com.stackroute.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    boolean existsByEmailId(String emailId);
    User findByEmailId(String emailId);

}
