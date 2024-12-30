package com.first.board.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Comment>

    // C R E A T E


    // D E L E T E


    // U P D A T E
}
