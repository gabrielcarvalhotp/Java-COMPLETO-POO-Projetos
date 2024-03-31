package com.gabrielcarvalhotp.course.resources;

import com.gabrielcarvalhotp.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1, "Mairia", "maria@gmail.com", "3596854966", "124567");
        return ResponseEntity.ok().body(user);
    }
}
