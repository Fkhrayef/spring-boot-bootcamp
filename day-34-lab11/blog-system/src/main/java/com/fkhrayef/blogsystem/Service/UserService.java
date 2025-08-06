package com.fkhrayef.blogsystem.Service;

import com.fkhrayef.blogsystem.Api.ApiException;
import com.fkhrayef.blogsystem.Model.User;
import com.fkhrayef.blogsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        user.setRegistrationDate(LocalDate.now());
        userRepository.save(user);
    }

    public void updateUser(Integer id, User user) {
        User oldUser = userRepository.findUserById(id);

        if (oldUser == null) {
            throw new ApiException("User not found");
        }

        if ((userRepository.findUserByEmail(user.getEmail()) != null && !oldUser.getEmail().equals(user.getEmail()))
                || (userRepository.findUserByUsername(user.getUsername()) != null) && !oldUser.getUsername().equals(user.getUsername())) {
            throw new ApiException("Email or username already exists");
        }

        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());

        userRepository.save(oldUser);
    }

    public void deleteUser(Integer id) {
        User oldUser = userRepository.findUserById(id);
        if (oldUser == null) {
            throw new ApiException("User not found");
        }
        userRepository.delete(oldUser);
    }

    public User login(String username, String password) {
        User user = userRepository.findUserByUsernameAndPassword(username, password);
        if (user == null) {
            throw new ApiException("Username or Password is wrong!");
        }
        return user;
    }
}
