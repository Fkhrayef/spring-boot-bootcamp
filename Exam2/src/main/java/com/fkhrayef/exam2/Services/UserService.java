package com.fkhrayef.exam2.Services;

import com.fkhrayef.exam2.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Boolean updateUser(String id, User user) {
        // Look for the user and update it if found
        for (int i = 0; i < users.size() ; i++) {
            if (users.get(i).getId().equals(id)) {
                users.set(i, user);
                return true;
            }
        }
        // if not found, return false
        return false;
    }

    public Boolean deleteUser(String id) {
        // Look for the user and delete it if found
        for (User user : users) {
            if (user.getId().equals(id))
                users.remove(user);
            return true;
        }
        // if not found, return false
        return false;
    }

    public ArrayList<User> getAboveBalance(Double balance) {
        ArrayList<User> filteredUsers = new ArrayList<>();

        for (User user : users) {
            if (user.getBalance() >= balance)
                filteredUsers.add(user);
        }

        return filteredUsers;
    }

    public ArrayList<User> getAboveAge(Integer age) {
        ArrayList<User> filteredUsers = new ArrayList<>();

        for (User user : users) {
            if (user.getAge() >= age)
                filteredUsers.add(user);
        }

        return filteredUsers;
    }
}
