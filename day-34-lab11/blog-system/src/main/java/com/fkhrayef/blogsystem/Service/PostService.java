package com.fkhrayef.blogsystem.Service;

import com.fkhrayef.blogsystem.Api.ApiException;
import com.fkhrayef.blogsystem.Model.Category;
import com.fkhrayef.blogsystem.Model.Post;
import com.fkhrayef.blogsystem.Model.User;
import com.fkhrayef.blogsystem.Repository.CategoryRepository;
import com.fkhrayef.blogsystem.Repository.PostRepository;
import com.fkhrayef.blogsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public void addPost(Post post) {
        if (userRepository.findUserById(post.getUserId()) == null) {
            throw new ApiException("User not found");
        }
        if (categoryRepository.findCategoryById(post.getCategoryId()) == null) {
            throw new ApiException("Category not found");
        }
        post.setPublishDate(LocalDate.now());
        postRepository.save(post);
    }

    public void updatePost(Integer id, Post post) {
        Post oldPost = postRepository.findPostById(id);
        if (oldPost == null) {
            throw new ApiException("Post not found");
        }

        if (userRepository.findUserById(post.getUserId()) == null) {
            throw new ApiException("User not found");
        }
        if (categoryRepository.findCategoryById(post.getCategoryId()) == null) {
            throw new ApiException("Category not found");
        }

        oldPost.setTitle(post.getTitle());
        oldPost.setContent(post.getContent());
        oldPost.setUserId(post.getUserId());
        oldPost.setCategoryId(post.getCategoryId());
        postRepository.save(oldPost);
    }

    public void deletePost(Integer id) {
        Post oldPost = postRepository.findPostById(id);
        if (oldPost == null) {
            throw new ApiException("Post not found");
        }
        postRepository.delete(oldPost);
    }

    public List<Post> getPostsByUserId(Integer userId) {
        if (userRepository.findUserById(userId) == null) {
            throw new ApiException("User not found");
        }
        return postRepository.retrieveUserPosts(userId);
    }

    public List<Post> getPostsByCategoryId(Integer categoryId) {
        if (categoryRepository.findCategoryById(categoryId) == null) {
            throw new ApiException("Category not found");
        }
        return postRepository.retrieveCategoryPosts(categoryId);
    }

    public List<Post> getLatestPosts(Integer limit) {
        if (limit <= 0) {
            throw new ApiException("Limit must be greater than 0");
        }
        return postRepository.retrieveLatestPosts(limit);
    }

    public List<Post> searchPostsByContent(String content) {
        if (content == null || content.isBlank()) {
            throw new ApiException("Content must not be empty");
        }
        return postRepository.findPostByContentLike("%" + content + "%");
    }
}
