package com.fkhrayef.jobseekingsystem.Controller;

import com.fkhrayef.jobseekingsystem.Model.JobApplication;
import com.fkhrayef.jobseekingsystem.Service.JobApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/job-applications")
@RequiredArgsConstructor
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    @RequestMapping("/get")
    public ResponseEntity<?> getAllJobApplications() {
        List<JobApplication> jobApplications = jobApplicationService.getAllJobApplications();

        if (!jobApplications.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(jobApplications);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Job Applications yet.");
        }
    }
}
