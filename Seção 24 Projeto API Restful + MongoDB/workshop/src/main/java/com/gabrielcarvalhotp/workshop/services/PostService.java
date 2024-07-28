package com.gabrielcarvalhotp.workshop.services;

import com.gabrielcarvalhotp.workshop.domains.posts.Post;
import com.gabrielcarvalhotp.workshop.repositories.PostRepository;
import com.gabrielcarvalhotp.workshop.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Post not found with id: " + id));
    }

    public List<Post> findByTitle(String title) {
        return postRepository.findByTitleContainingIgnoreCase(title);
    }
}
