package com.gabrielcarvalhotp.course.services;

import com.gabrielcarvalhotp.course.entities.User;
import com.gabrielcarvalhotp.course.repositories.UserRepository;
import com.gabrielcarvalhotp.course.services.exceptions.DatabaseException;
import com.gabrielcarvalhotp.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
        return userRepository.save(obj);
    }

    public void delete(Integer id) {
       try {
           userRepository.deleteById(id);
       } catch (EmptyResultDataAccessException exception) {
           throw new ResourceNotFoundException(id);
       } catch (DataIntegrityViolationException exception) {
           throw new DatabaseException(exception.getMessage());
       }
    }

    public User update( Integer id, User obj) {
        User user = userRepository.getReferenceById(id);
        updateData(obj, user);
        return userRepository.save(user);
    }

    private static void updateData(User source, User target) {
        target.setName(source.getName());
        target.setEmail(source.getEmail());
        target.setPhone(source.getPhone());
    }

}
