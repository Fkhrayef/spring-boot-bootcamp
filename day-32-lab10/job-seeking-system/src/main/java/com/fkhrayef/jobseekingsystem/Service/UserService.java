package com.fkhrayef.jobseekingsystem.Service;

import com.fkhrayef.jobseekingsystem.Model.JobApplication;
import com.fkhrayef.jobseekingsystem.Model.JobPost;
import com.fkhrayef.jobseekingsystem.Model.User;
import com.fkhrayef.jobseekingsystem.Repository.JobApplicationRepository;
import com.fkhrayef.jobseekingsystem.Repository.JobPostRepository;
import com.fkhrayef.jobseekingsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JobPostRepository jobPostRepository;
    private final JobApplicationRepository jobApplicationRepository;

    private final JobApplicationService jobApplicationService;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public Boolean updateUser(Integer id, User user) {
        User oldUser = userRepository.getById(id);
        if (oldUser == null) {
            return false;
        }

        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setAge(user.getAge());
        oldUser.setRole(user.getRole());
        userRepository.save(oldUser);
        return true;
    }

    public Boolean deleteUser(Integer id) {
        User user = userRepository.getById(id);
        if (user == null) {
            return false;
        }

        userRepository.delete(user);
        return true;
    }

    public String applyForJob(Integer id, Integer jobPostId) {
        // I know I should get it by id but since getById doesn't work properly, I did loop
        for (User user : getAllUsers()) {
            if (user.getId().equals(id)) {
                for (JobPost jobPost : jobPostRepository.findAll()) {
                    if (jobPost.getId().equals(jobPostId)) {
                        if (user.getRole().equals("JOB_SEEKER")) {
                            JobApplication jobApplication = new JobApplication();
                            jobApplication.setUserId(id);
                            jobApplication.setJobPostId(jobPostId);
                            jobApplicationRepository.save(jobApplication);
                            return "Job Application sent successfully.";
                        } else {
                            return "User must be a job seeker.";
                        }
                    }
                }
                return "Job Post not found.";
            }
        }
        return "User not found.";
    }

    // I can get the job application id instead, but I think this is more realistic.
    public String withdrawJobApplication(Integer id, Integer jobPostId) {
        // I know I should get it by id but since getById doesn't work properly, I did loop
        for (User user : getAllUsers()) {
            if (user.getId().equals(id)) {
                for (JobPost jobPost : jobPostRepository.findAll()) {
                    if (jobPost.getId().equals(jobPostId)) {
                        for (JobApplication jobApplication : jobApplicationRepository.findAll()) {
                            if (jobApplication.getUserId().equals(id) && jobApplication.getJobPostId().equals(jobPostId)) {
                                jobApplicationRepository.delete(jobApplication);
                                return "Job Application withdrawn successfully.";
                            }
                        }
                        return "Job Application not found.";
                    }
                }
                return "Job Post not found.";
            }
        }
        return "User not found.";
    }
}
