package com.gabrielcarvalhotp.workshop.repositories;

import com.gabrielcarvalhotp.workshop.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
