package com.first.board.comment;

import com.first.board.post.Post;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {
    private static Integer count = 1;
    // 댓글 ID, 작성자, 내용, 등록일, 추천수
    @Id
    @SequenceGenerator(
            name = "comment_id_seq",
            sequenceName = "comment_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "comment_id_seq"
    )
    private Integer commentId;
    @Lob
    private String commentWriter;
    private String commentcontent;
    @CreationTimestamp
    private Date comment_first_Created;
    @UpdateTimestamp
    private Date comment_last_created;
    private Integer likeCount = 0;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment(String commentWriter) {
        this.commentWriter = commentWriter;
    }

    public Comment(String commentWriter, String commentcontent) {
        this.commentWriter = commentWriter;
        this.commentcontent = commentcontent;
    }

    public Comment() {
        this.commentWriter = "Anonymous(" + (count++).toString() + ")";
        this.commentcontent = "None of the following.";
    }
}
