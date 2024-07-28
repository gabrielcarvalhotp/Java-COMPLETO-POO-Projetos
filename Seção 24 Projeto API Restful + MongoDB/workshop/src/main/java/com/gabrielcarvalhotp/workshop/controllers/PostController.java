package com.gabrielcarvalhotp.workshop.controllers;

import com.gabrielcarvalhotp.workshop.controllers.helpers.URIHelper;
import com.gabrielcarvalhotp.workshop.domains.posts.Post;
import com.gabrielcarvalhotp.workshop.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping("/title-seach")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "title", defaultValue = "") String title) {
        title = URIHelper.decodeUrlParam(title);
        List<Post> posts = postService.findByTitle(title);
        return ResponseEntity.ok().body(posts);
    }
}
