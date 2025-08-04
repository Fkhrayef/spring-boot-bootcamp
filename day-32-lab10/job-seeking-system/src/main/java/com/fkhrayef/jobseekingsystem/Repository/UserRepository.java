package com.fkhrayef.jobseekingsystem.Repository;

import com.fkhrayef.jobseekingsystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
