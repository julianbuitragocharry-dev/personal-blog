package com.personalblog.service;

import com.personalblog.entity.Post;
import com.personalblog.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    List<Post> getPostByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }

    void createPost(Post post) {
        postRepository.save(post);
    }

    void updatePost(Long id, Post post) {
        Post postDB = getPostById(id).orElseThrow(() -> new InvalidParameterException("Invalid post id"));
        postDB.setTitle(post.getTitle());
        postDB.setContent(post.getContent());
        postRepository.save(postDB);
    }

    void deletePostById(Long id) {
        postRepository.deleteById(id);
    }

    List<Post> searchPostByTitle(String title) {
        return postRepository.findByTitleContainingIgnoreCase(title);
    }
}
