package com.gabrielcarvalhotp.workshop.config;

import com.gabrielcarvalhotp.workshop.domains.posts.AuthorDTO;
import com.gabrielcarvalhotp.workshop.domains.posts.ComentsDTO;
import com.gabrielcarvalhotp.workshop.domains.posts.Post;
import com.gabrielcarvalhotp.workshop.domains.users.User;
import com.gabrielcarvalhotp.workshop.repositories.PostRepository;
import com.gabrielcarvalhotp.workshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class InitializationConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, bob, alex));

        ComentsDTO coments1 = new ComentsDTO("Boa viagem mano!", LocalDate.now(), new AuthorDTO(alex));
        ComentsDTO coments2 = new ComentsDTO("Aproveite", LocalDate.now(), new AuthorDTO(bob));
        ComentsDTO coments3 = new ComentsDTO("Tenha um ótimo dia!", LocalDate.now(), new AuthorDTO(alex));

        Post post1 = new Post(null, LocalDate.now(), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria), Arrays.asList(coments1, coments2));
        Post post2 = new Post(null, LocalDate.now(), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria), List.of(coments3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().add(post1);
        maria.getPosts().add(post2);
        userRepository.save(maria);
    }
}
