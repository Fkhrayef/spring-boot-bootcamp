package com.fkhrayef.blogsystem.Controller;

import com.fkhrayef.blogsystem.Api.ApiResponse;
import com.fkhrayef.blogsystem.Model.Comment;
import com.fkhrayef.blogsystem.Service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllComments() {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getAllComments());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addComment(@Valid @RequestBody Comment comment, Errors errors) {
        if (errors.hasErrors()) {
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors()) {
                errorMessages.add(error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        commentService.addComment(comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Comment added successfully" ));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateComment(@PathVariable("id") Integer id, @Valid @RequestBody Comment comment, Errors errors) {
        if (errors.hasErrors()) {
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors()) {
                errorMessages.add(error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        commentService.updateComment(id, comment);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Comment updated successfully" ));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable("id") Integer id) {
        commentService.deleteComment(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // get post's comments
    @GetMapping("/get/post/{id}")
    public ResponseEntity<?> getCommentsByPostId(@PathVariable("id") Integer postId) {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getCommentsByPostId(postId));
    }

    // gets user's comments
    @GetMapping("/get/user/{id}")
    public ResponseEntity<?> getCommentsByUserId(@PathVariable("id") Integer userId) {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getCommentsByUserId(userId));
    }
}
