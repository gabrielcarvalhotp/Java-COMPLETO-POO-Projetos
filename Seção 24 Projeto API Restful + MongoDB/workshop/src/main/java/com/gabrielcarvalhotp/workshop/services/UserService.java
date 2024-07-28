package com.gabrielcarvalhotp.workshop.services;

import com.gabrielcarvalhotp.workshop.domains.users.User;
import com.gabrielcarvalhotp.workshop.domains.users.UserDTO;
import com.gabrielcarvalhotp.workshop.repositories.UserRepository;
import com.gabrielcarvalhotp.workshop.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found with id: " + id));
    }

    public User createUser(UserDTO userDTO) {
        User user = new User(null, userDTO.name(), userDTO.email());
        return userRepository.insert(user);
    }

    public User updateUser(String id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found with id: " + id));
        user.setName(userDTO.name());
        user.setEmail(userDTO.email());
        return userRepository.save(user);
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}
