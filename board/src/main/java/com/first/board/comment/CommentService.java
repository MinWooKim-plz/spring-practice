package com.first.board.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // R E A D
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    // C R E A T E
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    // D E L E T E
    public void deleteComment(Integer id) {
        boolean exists = commentRepository.existsById(id);
        if (!exists) {
            throw new IllegalArgumentException("No comment found with id " + id);
        }
        commentRepository.deleteById(id);
    }

    // U P D A T E
    public void updateComment(Integer id, String commentContent) {
        Comment comment = commentRepository.getCommentsByCommentId(id)
                .orElseThrow(() -> new IllegalStateException("No comment found with id " + id));
        if (commentContent != null && commentContent.length() > 0 && !comment.getCommentContent().equals(commentContent)) {
            comment.setCommentContent(commentContent);
        }
        commentRepository.save(comment);
    }
}
