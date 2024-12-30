package com.first.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardApplication.class, args);
    }

}

//!! 삭제한 유저의 ID 재활용? -> 사용자가 많지 않으므로 일단 무시
//!! lombok 으로 인한 building 안 됨. -> 하드코딩