package com.fkhrayef.jobseekingsystem.Controller;

import com.fkhrayef.jobseekingsystem.Api.ApiResponse;
import com.fkhrayef.jobseekingsystem.Model.JobPost;
import com.fkhrayef.jobseekingsystem.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/job-posts")
@RequiredArgsConstructor
public class JobPostController {

    private final JobPostService jobPostService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllJobPosts() {
        List<JobPost> jobPosts = jobPostService.getAllJobPosts();

        if (!jobPosts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(jobPosts);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No Job Posts yet. Try adding some!"));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addJobPost(@Valid @RequestBody JobPost jobPost, Errors errors) {
        if (errors.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors()) {
                errorMessages.add(error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        jobPostService.addJobPost(jobPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Job Post added successfully!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateJobPost(@PathVariable("id") Integer id, @Valid @RequestBody JobPost jobPost, Errors errors) {
        if (errors.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors()) {
                errorMessages.add(error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        if (jobPostService.updateJobPost(id, jobPost)) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Job Post updated successfully!"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Job Post not found!"));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJobPost(@PathVariable("id") Integer id) {
        if (jobPostService.deleteJobPost(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Job Post not found!"));
        }
    }
}
