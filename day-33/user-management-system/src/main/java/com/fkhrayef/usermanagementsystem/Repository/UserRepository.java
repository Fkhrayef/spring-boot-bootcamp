package com.fkhrayef.usermanagementsystem.Repository;

import com.fkhrayef.usermanagementsystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(Integer id);

    @Query("SELECT u FROM User u WHERE u.username = ?1 AND u.password = ?2")
    User getSignedUpUser(String username, String password);

    User findUserByEmail(String email);

    User findUserByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.role = ?1")
    List<User> GetUsersWithRole(String role);

    @Query("SELECT u FROM User u WHERE u.age >= ?1")
    List<User> getUsersOlderThanAge(Integer age);
}
