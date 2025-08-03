package com.fkhrayef.amazonclonejpa.Repository;

import com.fkhrayef.amazonclonejpa.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
