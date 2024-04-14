package com.gabrielcarvalhotp.workshop.services;

import com.gabrielcarvalhotp.workshop.domain.User;
import com.gabrielcarvalhotp.workshop.dto.UserDTO;
import com.gabrielcarvalhotp.workshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        User user = null;
        try {
           user  = repository.findById(id).get();
        } catch (RuntimeException exception) {
            exception.printStackTrace();
        }
        return user;
    }

    public User insert(User user) {
        return repository.insert(user);
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    public void delete(String id) {
        repository.delete(findById(id));
    }

    public void update(User user) {
        repository.save(user);
    }

    public void update(User oldUser) {
        User user = repository.findById(oldUser.getId()).get();
        updateData(user, oldUser);
        repository.save(user);
    }

    private void updateData(User source, User target) {
        target.setName(source.getName());
        target.setEmail(source.getEmail());
    }

}
