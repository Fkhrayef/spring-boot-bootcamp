package com.fkhrayef.blogsystem.Service;

import com.fkhrayef.blogsystem.Api.ApiException;
import com.fkhrayef.blogsystem.Model.Comment;
import com.fkhrayef.blogsystem.Model.Post;
import com.fkhrayef.blogsystem.Repository.CommentRepository;
import com.fkhrayef.blogsystem.Repository.PostRepository;
import com.fkhrayef.blogsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public void addComment(Comment comment) {
        if (userRepository.findUserById(comment.getUserId()) == null) {
            throw new ApiException("User not found");
        }
        if (postRepository.findPostById(comment.getPostId()) == null) {
            throw new ApiException("Post not found");
        }
        comment.setCommentDate(LocalDate.now());
        commentRepository.save(comment);
    }

    public void updateComment(Integer id, Comment comment) {
        Comment oldComment = commentRepository.findCommentById(id);
        if (oldComment == null) {
            throw new ApiException("Comment not found");
        }

        if (userRepository.findUserById(comment.getUserId()) == null) {
            throw new ApiException("User not found");
        }
        if (postRepository.findPostById(comment.getPostId()) == null) {
            throw new ApiException("Post not found");
        }

        oldComment.setContent(comment.getContent());
        oldComment.setUserId(comment.getUserId());
        oldComment.setPostId(comment.getPostId());
        commentRepository.save(oldComment);
    }

    public void deleteComment(Integer id) {
        Comment oldComment = commentRepository.findCommentById(id);
        if (oldComment == null) {
            throw new ApiException("Comment not found");
        }
        commentRepository.delete(oldComment);
    }

    public List<Comment> getCommentsByPostId(Integer postId) {
        if (postRepository.findPostById(postId) == null) {
            throw new ApiException("Post not found");
        }
        return commentRepository.retrieveCommentsByPostId(postId);
    }

    public List<Comment> getCommentsByUserId(Integer userId) {
        if (userRepository.findUserById(userId) == null) {
            throw new ApiException("User not found");
        }
        return commentRepository.findCommentByUserId(userId);
    }
}
