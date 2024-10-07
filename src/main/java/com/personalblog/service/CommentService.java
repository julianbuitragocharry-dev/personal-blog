package com.personalblog.service;

import com.personalblog.entity.Comment;
import com.personalblog.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    void createComment(Comment comment) {
        commentRepository.save(comment);
    }

    void updateComment(Long id, Comment comment) {
        Comment commentDB = commentRepository.findById(id).orElseThrow(() -> new InvalidParameterException("Invalid comment id"));
        commentDB.setContent(comment.getContent());
        commentRepository.save(commentDB);
    }

    void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
