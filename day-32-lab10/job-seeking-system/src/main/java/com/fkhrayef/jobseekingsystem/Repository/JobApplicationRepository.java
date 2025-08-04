package com.fkhrayef.jobseekingsystem.Repository;

import com.fkhrayef.jobseekingsystem.Model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer> {
}
