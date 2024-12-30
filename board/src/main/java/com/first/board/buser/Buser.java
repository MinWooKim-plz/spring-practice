package com.first.board.buser;

import jakarta.persistence.*;

@Entity // 해당 클래스가 JPA(Java Persistence API)를 사용해 데이터베이스 테이블과 매핑되는 엔티티임
// 클래스 이름이 기본적으로 데이터베이스 테이블 이름과 매핑되지만, 이를 @Table로 수정 가능
// 필수조건 1. 기본 생성자 2. @Id
@Table(name = "Buser")
public class Buser {
    private static Integer count = 1;
    @Id
    @SequenceGenerator(                         // DB에서 시퀀스를 사용하여 기본 키 값을 자동으로 생성
            name = "user_id_seq",               // JPA에서 참조할 시퀀스 제너레이터의 이름 (고유해야 함).
            sequenceName = "user_id_seq",       // 데이터베이스에서 사용할 실제 시퀀스 이름 (고유해야 함).
            allocationSize = 1                  // id auto increment

    )
    @GeneratedValue(                            // DB에서 id auto increment
            strategy = GenerationType.SEQUENCE, // ID 생성 전략 지정 (SEQUENCE, IDENTITY, AUTO, TABLE).
            generator = "user_id_seq"           // 참조할 시퀀스 제너레이터의 이름 (JPA의 name과 일치해야 함).
    )
    private Integer id;
    private String name;
    private String email;
    // 작성한 글의 제목들 : private List<>
    private Integer writing_numbers = 0;        // 작성한 글의 제목들의 개수로 계속 초기화하면 될 듯.

    public Buser() {
        this.name = "Anonymous(Not setup:" + (count).toString() + ")";
        this.email = "NONE(" + (count++).toString() + ")";
    }

    public Buser(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWriting_numbers() {
        return writing_numbers;
    }

    public void setWriting_numbers(Integer writing_numbers) {
        this.writing_numbers = writing_numbers;
    }
}
