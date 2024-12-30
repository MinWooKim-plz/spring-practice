package com.first.board.post;

import com.first.board.comment.Comment;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @CreationTimestamp
    private Date first_created;
    @UpdateTimestamp
    private Date last_created;
    private Integer likeCount = 0;
    //  mappedBy 속성은 Comment 클래스의 post 필드와 매핑됩니다.
    //	cascade = CascadeType.ALL은 Post가 삭제될 때, 해당 Post와 연관된 Comment들도 함께 삭제되도록 합니다.
    //	orphanRemoval = true는 Post와 관계가 끊어진 Comment가 자동으로 삭제되도록 합니다.
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<Comment>();


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
        this.writer = "Anonymous" + (count++).toString() + ")";
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
