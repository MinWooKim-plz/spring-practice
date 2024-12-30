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
    //    @Lob
    private String commentWriter;
    private String commentContent;
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

    public Comment(String commentWriter, String commentContent) {
        this.commentWriter = commentWriter;
        this.commentContent = commentContent;
    }

    public Comment() {
        this.commentWriter = "Anonymous(" + (count++).toString() + ")";
        this.commentContent = "None of the following.";
    }

    public static Integer getCount() {
        return count;
    }

    public static void setCount(Integer count) {
        Comment.count = count;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentWriter() {
        return commentWriter;
    }

    public void setCommentWriter(String commentWriter) {
        this.commentWriter = commentWriter;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getComment_first_Created() {
        return comment_first_Created;
    }

    public void setComment_first_Created(Date comment_first_Created) {
        this.comment_first_Created = comment_first_Created;
    }

    public Date getComment_last_created() {
        return comment_last_created;
    }

    public void setComment_last_created(Date comment_last_created) {
        this.comment_last_created = comment_last_created;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
