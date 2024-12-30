package com.first.board.post;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "post")
public class Post {
    private static Integer count = 1;
    // 글 ID, 작성자, 제목, 내용, 등록일들
    @Id
    @SequenceGenerator(
            name = "post_id_seq",
            sequenceName = "post_id_seq",
            allocationSize = 1 // id auto increment
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_id_seq"
    )
    private Integer id;
    private String writer;
    @Lob
    private String title;
    private String content;
    private Date first_created = new Date();
    private Date last_created = first_created;
    private Integer likeCount = 0;


    public Post(String writer, String title) {
        this.writer = writer;
        this.title = title;
        this.content = "Not Yet Implemented.";
    }

    public Post(String writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    public Post() {
        this.writer = "Anonymous" + (count).toString() + ")";
        this.title = "None" + (count++).toString() + ")";
        this.content = "None of the following.";
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getFirst_created() {
        return first_created;
    }

    public void setFirst_created(Date first_created) {
        this.first_created = first_created;
    }

    public Date getLast_created() {
        return last_created;
    }

    public void setLast_created(Date last_created) {
        this.last_created = last_created;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }
}
