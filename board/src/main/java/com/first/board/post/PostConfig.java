package com.first.board.post;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PostConfig {
    @Bean
    CommandLineRunner commandLineRunner3(PostRepository postRepository) {
        return args -> {
            Post post1 = new Post("fia", "hello world");
            Post post2 = new Post("chulsoo", "second post");
            postRepository.saveAll(List.of(post1, post2));
        };
    }
}
