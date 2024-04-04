package com.gabrielcarvalhotp.course.repositories;


import com.gabrielcarvalhotp.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
