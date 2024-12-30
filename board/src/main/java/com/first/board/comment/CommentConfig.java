package com.first.board.comment;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CommentConfig {
    @Bean
    CommandLineRunner commandLineRunner2(CommentRepository commentRepository) {
        return args -> {
            Comment comment1 = new Comment("jack", "hi there what is ");
            Comment comment2 = new Comment("boa", "hi there i'm hungry. you have a great time ");
            commentRepository.saveAll(List.of(comment1, comment2));
        };
    }
}
