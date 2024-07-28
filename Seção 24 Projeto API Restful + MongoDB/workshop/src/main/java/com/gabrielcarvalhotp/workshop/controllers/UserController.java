package com.gabrielcarvalhotp.workshop.controllers;

import com.gabrielcarvalhotp.workshop.domains.posts.Post;
import com.gabrielcarvalhotp.workshop.domains.users.User;
import com.gabrielcarvalhotp.workshop.domains.users.UserDTO;
import com.gabrielcarvalhotp.workshop.services.PostService;
import com.gabrielcarvalhotp.workshop.services.UserService;
import com.gabrielcarvalhotp.workshop.controllers.helpers.URIHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<Post>> findPostsByUserId(@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user.getPosts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody UserDTO userDTO) {
        User user = userService.updateUser(id, userDTO);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        User user = userService.createUser(userDTO);
        URI uri = URIHelper.createUri("/{id}", user.getId());
        return ResponseEntity.created(uri).body(user);
    }
}
