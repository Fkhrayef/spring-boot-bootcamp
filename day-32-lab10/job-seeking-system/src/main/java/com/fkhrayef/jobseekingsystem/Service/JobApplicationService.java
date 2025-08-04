package com.fkhrayef.jobseekingsystem.Service;

import com.fkhrayef.jobseekingsystem.Model.JobApplication;
import com.fkhrayef.jobseekingsystem.Repository.JobApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;

    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }

}
