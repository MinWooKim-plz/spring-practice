package com.first.board.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class PostService {
    private static PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // R E A D
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPost(Integer id) {
        return postRepository.getPostById(id).orElseThrow(() -> new IllegalStateException("No post found"));
    }

    // C R E A T E
    public void addPost(Post post) {
        postRepository.save(post);
    }

    // D E L E T E
    public void deletePost(Integer id) {
        boolean exists = postRepository.existsById(id);
        if (!exists) {
            throw new IllegalArgumentException("No post found with id " + id);
        }
        postRepository.deleteById(id);
    }

    // U P D A T E
    @Transactional
    public void updatePost(Integer id, String title, String content) {
        Post post = postRepository.getPostById(id).orElseThrow(() -> new IllegalStateException("No post found with id " + id));
        if (title != null && title.length() > 0 && !Objects.equals(title, post.getTitle()))
            post.setTitle(title);
        if (content != null && content.length() > 0 && !Objects.equals(content, post.getContent()))
            post.setContent(content);
        postRepository.save(post);
    }
}
