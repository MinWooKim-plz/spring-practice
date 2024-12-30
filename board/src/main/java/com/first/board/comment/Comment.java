package com.first.board.comment;

import jakarta.persistence.Lob;

import java.util.Date;

public class Comment {
    // 글 ID
    private Integer id;
    // 글 작성자
    private String writer;
    // 글 제목
    @Lob // 대용량 처리(DB에서 TEXT타입 처리)
    private String title;
    // 글 내용 (?) : 글 내용은 크기가 훨씬 커야하지 않나?
    private String content;
    // 글 등록일
    private Date created;
    // 글의 댓글 ID


    private Integer commentId;
    // 댓글 작성자
    private String commentWriter;
    // 댓글 내용
    private String commentTitle;
    // 댓글 등록일
    private Date commentCreated;
    // 추천수
    private Integer likeCount;

}
