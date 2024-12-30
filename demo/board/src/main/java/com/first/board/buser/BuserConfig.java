package com.first.board.buser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BuserConfig {
    @Bean
    CommandLineRunner commandLineRunner(BuserRepository buserRepository) {
        return args -> {
            Buser kim = new Buser("minu@qwer@.com", "kimmin");
            buserRepository.saveAll(List.of(kim));
        };
    }
}
