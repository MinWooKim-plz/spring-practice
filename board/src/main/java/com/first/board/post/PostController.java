package com.first.board.post;

import com.first.board.comment.Comment;
import com.first.board.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/post")
public class PostController {
    private final PostService postService;
    private final CommentService commentService;

    @Autowired
    public PostController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }
    /*
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
    */

    // #########################################################################
    // 게시글 목록
    @GetMapping
    public String getPosts(Model model) {
        List<Post> posts = postService.getPosts();
        model.addAttribute("posts", posts);
        return "posts";  // posts.html 템플릿
    }

    // 게시글 작성 폼
    @GetMapping("/create")
    public String showCreatePostForm() {
        return "createPost";  // createPost.html 템플릿
    }

    // 게시글 작성
    @PostMapping
    public String addPost(@ModelAttribute Post post) {
        postService.addPost(post);
        return "redirect:/post";  // 게시글 목록으로 리다이렉트
    }

    // 게시글 상세 화면
    @GetMapping("/{id}")
    public String getPostDetail(@PathVariable Integer id, Model model) {
        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        return "postDetail";  // postDetail.html 템플릿
    }

    // 게시글 삭제
    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return "redirect:/post";  // 게시글 목록으로 리다이렉트
    }

    // 댓글 추가
    @PostMapping("/comment/add")
    public String addComment(@RequestParam String content, @RequestParam Integer postId) {
        Comment comment = new Comment();
        comment.setCommentContent(content);
        comment.setPost(postService.getPost(postId));
        commentService.addComment(comment);
        return "redirect:/post/" + postId;  // 게시글 상세 페이지로 리다이렉트
    }

    // 댓글 삭제
    @PostMapping("/comment/delete/{id}")
    public String deleteComment(@PathVariable Integer id, @RequestParam Integer postId) {
        commentService.deleteComment(id);
        return "redirect:/post/" + postId;  // 게시글 상세 페이지로 리다이렉트
    }
}
