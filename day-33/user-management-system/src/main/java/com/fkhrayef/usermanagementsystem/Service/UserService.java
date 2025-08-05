package com.fkhrayef.usermanagementsystem.Service;

import com.fkhrayef.usermanagementsystem.Api.ApiException;
import com.fkhrayef.usermanagementsystem.Model.User;
import com.fkhrayef.usermanagementsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        if (userRepository.findUserByEmail(user.getEmail()) != null || userRepository.findUserByUsername(user.getUsername()) != null) {
            throw new ApiException("Email or username already exists");
        }
        userRepository.save(user);
    }

    public void updateUser(Integer id, User user) {
        User oldUser = userRepository.findUserById(id);

        if (oldUser == null) {
            throw new ApiException("User not found");
        }

        if (userRepository.findUserByEmail(user.getEmail()) != null || userRepository.findUserByUsername(user.getUsername()) != null) {
            throw new ApiException("Email or username already exists");
        }

        oldUser.setName(user.getName());
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(user.getRole());
        oldUser.setAge(user.getAge());

        userRepository.save(oldUser);
    }

    public void deleteUser(Integer id) {
        User oldUser = userRepository.findUserById(id);
        if (oldUser == null) {
            throw new ApiException("User not found");
        }
        userRepository.delete(oldUser);
    }

    public void login(String username, String password) {
        User user = userRepository.getSignedUpUser(username, password);
        if (user == null) {
            throw new ApiException("Invalid username or password");
        }
    }

    public User getUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        if (user == null) {
            throw new ApiException("User not found");
        }
        return user;
    }

    public List<User> getAllUsersByRole(String role) {
        return userRepository.GetUsersWithRole(role);
    }

    public List<User> getUsersOlderThanAge(Integer age) {
        return userRepository.getUsersOlderThanAge(age);
    }
}
