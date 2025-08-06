package com.fkhrayef.blogsystem.Controller;

import com.fkhrayef.blogsystem.Model.Post;
import com.fkhrayef.blogsystem.Service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllPosts() {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPost(@Valid @RequestBody Post post, Errors errors) {
        if (errors.hasErrors()) {
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors()) {
                errorMessages.add(error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        postService.addPost(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ArrayList<String>(){{add("Post added successfully");}});
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePost(@PathVariable("id") Integer id, @Valid @RequestBody Post post, Errors errors) {
        if (errors.hasErrors()) {
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors()) {
                errorMessages.add(error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }
        postService.updatePost(id, post);
        return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<String>(){{add("Post updated successfully");}});
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable("id") Integer id) {
        postService.deletePost(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // gets user's posts
    @GetMapping("/get/user/{id}")
    public ResponseEntity<?> getPostsByUserId(@PathVariable("id") Integer userId) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPostsByUserId(userId));
    }

    // gets category's posts
    @GetMapping("/get/category/{id}")
    public ResponseEntity<?> getPostsByCategoryId(@PathVariable("id") Integer categoryId) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPostsByCategoryId(categoryId));
    }

    // gets latest posts by limit
    @GetMapping("/get/latest")
    public ResponseEntity<?> getLatestPosts(@RequestParam(value = "limit", defaultValue = "5") Integer limit) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getLatestPosts(limit));
    }

    // searches posts by part of the content
    @GetMapping("/get/search/content/{content}")
    public ResponseEntity<?> searchPostsByContent(@PathVariable("content") String content) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.searchPostsByContent(content));
    }
}
