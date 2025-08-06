package com.fkhrayef.blogsystem.Repository;

import com.fkhrayef.blogsystem.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    Post findPostById(Integer id);

    @Query("SELECT p FROM Post p WHERE p.userId = ?1")
    List<Post> retrieveUserPosts(Integer userId);

    @Query("SELECT p FROM Post p WHERE p.categoryId = ?1")
    List<Post> retrieveCategoryPosts(Integer categoryId);

    @Query("SELECT p FROM Post p ORDER BY p.publishDate DESC LIMIT ?1")
    List<Post> retrieveLatestPosts(Integer limit);

    List<Post> findPostByContentLike(String content);
}
