package com.user.web.repository;
import com.user.web.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    User findFirstByUsername(String userId);
    User getById(String id);
    Boolean existsByUsername(String userId);
    List<User> findAll();
}
