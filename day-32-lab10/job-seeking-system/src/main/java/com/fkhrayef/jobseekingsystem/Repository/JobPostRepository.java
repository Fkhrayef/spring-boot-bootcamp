package com.fkhrayef.jobseekingsystem.Repository;

import com.fkhrayef.jobseekingsystem.Model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, Integer> {
}
