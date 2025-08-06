package com.fkhrayef.blogsystem.Repository;

import com.fkhrayef.blogsystem.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Comment findCommentById(Integer id);

    @Query("SELECT c FROM Comment c WHERE c.postId = ?1")
    List<Comment> retrieveCommentsByPostId(Integer postId);

    List<Comment> findCommentByUserId(Integer userId);
}
