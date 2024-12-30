package com.first.board.comment;

import com.first.board.post.Post;
import com.first.board.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/post")
public class CommentController {
    private final PostService postService;
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
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
        Optional<Post> post = Optional.ofNullable(postService.getPost(postId));
        if (post.isPresent()) {
            // Post와 Comment 양방향 연결
            comment.setPost(post.get());
            post.get().getComments().add(comment);  // Post의 댓글 리스트에도 추가
            commentService.addComment(comment);  // 댓글 서비스에 저장
        } else {
            // Post not found 처리
            throw new RuntimeException("Post not found");
        }
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
