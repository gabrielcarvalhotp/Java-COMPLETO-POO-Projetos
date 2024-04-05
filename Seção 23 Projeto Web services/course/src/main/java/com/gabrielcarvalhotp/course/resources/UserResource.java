package com.gabrielcarvalhotp.course.resources;

import com.gabrielcarvalhotp.course.entities.User;
import com.gabrielcarvalhotp.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok().body(userService.listAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {
        User user = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User User) {
        return ResponseEntity.ok(userService.update(id, User));
    }
}
