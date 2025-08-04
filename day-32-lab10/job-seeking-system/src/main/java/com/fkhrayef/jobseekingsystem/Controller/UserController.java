package com.fkhrayef.jobseekingsystem.Controller;

import com.fkhrayef.jobseekingsystem.Api.ApiResponse;
import com.fkhrayef.jobseekingsystem.Model.User;
import com.fkhrayef.jobseekingsystem.Service.UserService;
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
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userService.getAllUsers();

        if (!users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(users);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No Users yet. Try adding some!"));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors()) {
                errorMessages.add(error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("User added successfully!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Integer id, @Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors()) {
                errorMessages.add(error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        if (userService.updateUser(id, user)) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("User updated successfully!"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("User not found!"));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
        if (userService.deleteUser(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("User not found!"));
        }
    }

    @PostMapping("/apply/{id}/{jobPostId}")
    public ResponseEntity<?> applyForJob(@PathVariable("id") Integer id, @PathVariable("jobPostId") Integer jobPostId) {
        String result = userService.applyForJob(id, jobPostId);
        if (result.equals("User not found.") || result.equals("Job Post not found.")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(result));
        } else if (result.equals("User must be a job seeker.")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse(result));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Job Application sent successfully!"));
        }
    }

    @PostMapping("/withdraw/{id}/{jobPostId}")
    public ResponseEntity<?> withdrawJobApplication(@PathVariable("id") Integer id, @PathVariable("jobPostId") Integer jobPostId) {
        String result = userService.withdrawJobApplication(id, jobPostId);
        if (result.equals("User not found.") || result.equals("Job Post not found.") || result.equals("Job Application not found.")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(result));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Job Application withdrawn successfully!"));
        }
    }
}
