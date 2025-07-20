package com.fkhrayef.project.Controller;

import com.fkhrayef.project.Api.ApiResponse;
import com.fkhrayef.project.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/")
public class ProjectController {

    ArrayList<Project> projects = new ArrayList<>();

    @GetMapping("get/projects")
    public ArrayList<Project> getAllProjects(){
        return projects;
    }

    @GetMapping("get/projects/search")
    public ArrayList<Project> searchProjects(@RequestParam("query") String query) {
        ArrayList<Project> candidates = new ArrayList<>();
        for (Project project : projects) {
            if (project.getTitle().toLowerCase().startsWith(query.toLowerCase())) {
                candidates.add(project);
            }
        }
        return candidates;
    }

    @GetMapping("get/projects/company")
    public ArrayList<Project> getCompanyProjects(@RequestParam("companyName") String companyName) {
        ArrayList<Project> candidates = new ArrayList<>();
        for (Project project : projects) {
            if (project.getCompanyName().equalsIgnoreCase(companyName.toLowerCase())) {
                candidates.add(project);
            }
        }
        return candidates;
    }

    @PostMapping("add/project")
    public ApiResponse addProject(@RequestBody Project project){
        for (Project p : projects) {
            if (p.getId() == project.getId()) {
                return new ApiResponse("Project ID Already Exists!", "400");
            }
        }
        projects.add(new Project(project.getId(), project.getTitle(), project.getDescription(), project.getStatus(), project.getCompanyName()));
        return new ApiResponse("Project Added Successfully!", "200");
    }

    @PutMapping("update/projects/{projectId}")
    public ApiResponse updateProject(@PathVariable("projectId") int projectId, @RequestBody Project project) {
        // Get the project by its id
        Project projectToUpdate = null;
        for (Project p : projects) {
            if (p.getId() == projectId) {
                projectToUpdate = p;
                break;
            }
        }

        // If found, update it. If not, return not found!
        if (projectToUpdate != null) {
            projectToUpdate.setTitle(project.getTitle());
            projectToUpdate.setDescription(project.getDescription());
            projectToUpdate.setStatus(project.getStatus());
            projectToUpdate.setCompanyName(project.getCompanyName());
            return new ApiResponse("Project Updated Successfully!", "200");
        } else {
            return new ApiResponse("Project Not Found!", "404");
        }
    }

    @PutMapping("update/projects/{projectId}/status-toggle")
    public ApiResponse toggleProjectStatus(@PathVariable("projectId") int projectId) {
        // Get the project by its id
        Project projectToUpdate = null;
        for (Project p : projects) {
            if (p.getId() == projectId) {
                projectToUpdate = p;
                break;
            }
        }

        // If found, toggle status. If not, return not found!
        if (projectToUpdate != null) {
            if (projectToUpdate.getStatus().equals("Done")) {
                projectToUpdate.setStatus("Not Done");
            } else {
                projectToUpdate.setStatus("Done");
            }
            return new ApiResponse("Project Status Toggled Successfully!", "200");
        } else {
            return new ApiResponse("Project Not Found!", "404");
        }
    }


    @DeleteMapping("delete/projects/{projectId}")
    public ApiResponse deleteProject(@PathVariable("projectId") int projectId) {
        // Get the project by its id
        Project projectToDelete = null;
        for (Project t : projects) {
            if (t.getId() == projectId) {
                projectToDelete = t;
                break;
            }
        }

        // If found, delete it. If not, return not found!
        if (projectToDelete != null) {
            projects.remove(projectToDelete);
            return new ApiResponse("Project Deleted Successfully!", "200");
        } else {
            return new ApiResponse("Project Not Found!", "404");
        }
    }
}
