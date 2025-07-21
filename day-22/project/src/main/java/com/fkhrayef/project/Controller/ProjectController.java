package com.fkhrayef.project.Controller;

import com.fkhrayef.project.Model.Project;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/")
public class ProjectController {

    ArrayList<Project> projects = new ArrayList<>();

    @GetMapping("get/projects")
    public ResponseEntity<?> getAllProjects(){
        return ResponseEntity.status(HttpStatus.OK).body(projects);
    }

    @GetMapping("get/projects/search")
    public ResponseEntity<?> searchProjects(@RequestParam String query){
        ArrayList<Project> filteredProjects = new ArrayList<>();
        for(Project project : projects){
            if(project.getTitle().toLowerCase().startsWith(query.toLowerCase())){
                filteredProjects.add(project);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(filteredProjects);
    }

    @GetMapping("get/projects/company")
    public ResponseEntity<?> getCompanyProjects(@RequestParam("companyName") String companyName) {
        ArrayList<Project> filteredProjects = new ArrayList<>();
        for (Project project : projects) {
            if (project.getCompanyName().equalsIgnoreCase(companyName.toLowerCase())) {
                filteredProjects.add(project);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(filteredProjects);
    }

    @PostMapping("add/project")
    public ResponseEntity<?> addProject(@Valid @RequestBody Project project, Errors errors){
        // Check for validation errors
        if (errors.hasErrors()) {
            // I want to get fancy and get all error messages (if exist), not just one.
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors()) {
                errorMessages.add(error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        projects.add(project);
        return ResponseEntity.status(HttpStatus.CREATED).body("Project added successfully");
    }

    @PutMapping("update/projects/{projectIndex}")
    public ResponseEntity<?> updateProject(@PathVariable("projectIndex") int projectIndex, @Valid @RequestBody Project project, Errors errors) {
        // Validate correct index
        if (projectIndex < 0 || projectIndex >= projects.size()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Project index is out of bounds");
        }

        // Check for validation errors
        if (errors.hasErrors()) {
            // I want to get fancy and get all error messages (if exist), not just one.
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors()) {
                errorMessages.add(error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        projects.set(projectIndex, project);
        return ResponseEntity.status(HttpStatus.OK).body("Project updated successfully");
    }

    @PutMapping("update/projects/{projectIndex}/status-toggle")
    public ResponseEntity<?> toggleProjectStatus(@PathVariable("projectIndex") int projectIndex) {
        // Validate correct index
        if (projectIndex < 0 || projectIndex >= projects.size()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Project index is out of bounds");
        }

        // toggle between the three states: Not Started -> In Progress -> Completed
        Project project = projects.get(projectIndex);
        if (project.getStatus().equalsIgnoreCase("Not Started")) {
            project.setStatus("In Progress");
        } else if (project.getStatus().equalsIgnoreCase("In Progress")) {
            project.setStatus("Completed");
        } else {
            project.setStatus("Not Started");
        }
        projects.set(projectIndex, project);
        return ResponseEntity.status(HttpStatus.OK).body("Project status updated successfully");
    }

    @DeleteMapping("delete/projects/{projectIndex}")
    public ResponseEntity<?> deleteProject(@PathVariable("projectIndex") int projectIndex) {
        // Validate correct index
        if (projectIndex < 0 || projectIndex >= projects.size()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Project index is out of bounds");
        }
        projects.remove(projectIndex);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Project deleted successfully"); // Note: the message won't show
    }
}
