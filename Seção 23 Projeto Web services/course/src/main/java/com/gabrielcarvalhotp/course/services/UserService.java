package com.gabrielcarvalhotp.course.services;

import com.gabrielcarvalhotp.course.entities.User;
import com.gabrielcarvalhotp.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }

    public User insert(User obj) {
        return userRepository.save(obj);
    }
}
