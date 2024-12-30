package com.first.board.comment;

import jakarta.persistence.*;

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
    private Date comment_first_Created = new Date();
    private Date comment_last_created = comment_first_Created;
    private Integer likeCount = 0;

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
