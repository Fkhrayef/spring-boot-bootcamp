package com.fkhrayef.exam2.Controller;

import com.fkhrayef.exam2.ApiResponse.ApiResponse;
import com.fkhrayef.exam2.Model.User;
import com.fkhrayef.exam2.Services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity<?> getUsers() {
        ArrayList<User> users = userService.getUsers();

        if (!users.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(users);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No users yet. Try adding some!"));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody User user, Errors errors) {
        // Check for validation errors
        if (errors.hasErrors()) {
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors())
                errorMessages.add(error.getDefaultMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        // add user
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") String id, @Valid @RequestBody User user, Errors errors) {
        // Check for validation errors
        if (errors.hasErrors()) {
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors())
                errorMessages.add(error.getDefaultMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        if (userService.updateUser(id, user))
            return ResponseEntity.status(HttpStatus.OK).body(user);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("User not found!"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {
        if (userService.deleteUser(id))
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse("Deleted")); // the message won't show up because status is 204 NO CONTENT
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("User not found!"));
    }

    @GetMapping("/get/above-balance")
    public ResponseEntity<?> getAboveBalance(@RequestParam("balance") Double balance) {
        ArrayList<User> filteredUsers = userService.getAboveBalance(balance);

        if (!filteredUsers.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(filteredUsers);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No users meet your criteria!"));

    }

    @GetMapping("/get/above-age")
    public ResponseEntity<?> getAboveAge(@RequestParam("age") Integer age) {
        ArrayList<User> filteredUsers = userService.getAboveAge(age);

        if (!filteredUsers.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(filteredUsers);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No users meet your criteria!"));
    }
}
