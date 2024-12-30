package com.first.board.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/post")
public class CommentController {
    private static CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // R E A D
    // @GetMapping(path = "/comment") // 해당 post id의 comments여야 함.
    @GetMapping(path = "/{post_id}/comment") // 해당 post id의 comments
    public List<Comment> getComments(@PathVariable(name = "post_id") Integer postId) {
        return commentService.getComments();
    }

    // C R E A T E
    @PostMapping(path = "/{post_id}/comment") // 해당 post id로 comment 생성.
    public void addComment(@PathVariable(name = "post_id") Integer postId, @RequestBody Comment comment) {
//        comment.setPostId(postId);
        commentService.addComment(comment);
    }

    // D E L E T E
    @DeleteMapping(path = "/{comment_id}")
    public void deleteComment(@PathVariable(name = "comment_id") Integer id) {
        commentService.deleteComment(id);
    }

    // U P D A T E
    @PutMapping(path = "/{comment_id}")
    public void updateComment(@PathVariable(name = "comment_id") Integer id, @RequestBody Comment comment) {
        commentService.updateComment(id, comment.getCommentContent());
    }
}
