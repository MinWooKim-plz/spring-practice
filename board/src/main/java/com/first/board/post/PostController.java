package com.first.board.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/post")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // R E A D
    @GetMapping
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @GetMapping(path = "/{post_id}")
    public Post getPost(@PathVariable Integer id) {
        return postService.getPost(id);
    }

    // C R E A T E
    @PostMapping
    public void addPost(@RequestBody Post post) {
        postService.addPost(post);
    }

    // D E L E T E
    @DeleteMapping
    public void deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
    }

    // U P D A T E
    @PutMapping(path = "/{post_id}")
    public void updatePost(@PathVariable Integer id, @RequestBody Post post) {
        postService.updatePost(id, post.getTitle(), post.getContent());
    }
}
