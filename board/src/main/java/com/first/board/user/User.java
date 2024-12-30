package com.first.board.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity // 해당 클래스가 JPA(Java Persistence API)를 사용해 데이터베이스 테이블과 매핑되는 엔티티임
// 클래스 이름이 기본적으로 데이터베이스 테이블 이름과 매핑되지만, 이를 @Table로 수정 가능
// 필수조건 1. 기본 생성자 2. @Id
@Getter
@Setter
@Table(name = "boarduser")
public class User {
    @Id
    @SequenceGenerator( // DB에서 시퀀스를 사용하여 기본 키 값을 자동으로 생성
            name = "user_id_seq",
            sequenceName = "user_id_seq",
            allocationSize = 1 // id auto increment
    )
    @GeneratedValue(    // DB에서 id auto increment
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_seq"
    )
    private Integer id;
    private String name;
    private String email;
    private Integer writing_numbers = 0; // 작성한 글의 제목들의 개수로 계속 초기화하면 될 듯.
    // 작성한 글의 제목들 : private List<>

    public User() {
        this.name = "Anonymous(Not setup)";
        this.email = "anonymous@anonymous.com";
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
