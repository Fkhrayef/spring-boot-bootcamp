package com.fkhrayef.task.Controller;

import com.fkhrayef.task.Api.ApiResponse;
import com.fkhrayef.task.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/")
public class TaskController {

    ArrayList<Task> tasks = new ArrayList<>();

    @GetMapping("get/tasks")
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @GetMapping("get/tasks/{taskId}")
    public Task getTask(@PathVariable("taskId") int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                return task;
            }
        }
        return null;
    }

    @GetMapping("get/tasks/search")
    public ArrayList<Task> searchTasks(@RequestParam("query") String query) {
        ArrayList<Task> candidates = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getTitle().toLowerCase().contains(query.toLowerCase())) {
                candidates.add(task);
            }
        }
        return candidates;
    }

    @PostMapping("add/task")
    public ApiResponse addTask(@RequestBody Task task) {
        for (Task t : tasks) {
            if (t.getId() == task.getId()) {
                return new ApiResponse("Task ID Already Exists!", "400");
            }
        }
        tasks.add(new Task(task.getId(), task.getTitle(), task.getDescription(), task.isStatus()));
        return new ApiResponse("Task Added Successfully!", "200");
    }

    @PutMapping("update/tasks/{taskId}")
    public ApiResponse updateTask(@PathVariable("taskId") int taskId, @RequestBody Task task) {
        // Get the task by its id
        Task taskToUpdate = null;
        for (Task t : tasks) {
            if (t.getId() == taskId) {
                taskToUpdate = t;
                break;
            }
        }

        // If found, update it. If not, return not found!
        if (taskToUpdate != null) {
            taskToUpdate.setTitle(task.getTitle());
            taskToUpdate.setDescription(task.getDescription());
            taskToUpdate.setStatus(task.isStatus());
            return new ApiResponse("Task Updated Successfully!", "200");
        } else {
            return new ApiResponse("Task Not Found!", "404");
        }
    }

    @PutMapping("update/tasks/{taskId}/status-toggle")
    public ApiResponse toggleTaskStatus(@PathVariable("taskId") int taskId) {
        // Get the task by its id
        Task taskToUpdate = null;
        for (Task t : tasks) {
            if (t.getId() == taskId) {
                taskToUpdate = t;
                break;
            }
        }

        // If found, toggle status. If not, return not found!
        if (taskToUpdate != null) {
            taskToUpdate.setStatus(!taskToUpdate.isStatus());
            return new ApiResponse("Task Status Toggled Successfully!", "200");
        } else {
            return new ApiResponse("Task Not Found!", "404");
        }
    }

    @DeleteMapping("delete/tasks/{taskId}")
    public ApiResponse deleteTask(@PathVariable("taskId") int taskId) {
        // Get the task by its id
        Task taskToDelete = null;
        for (Task t : tasks) {
            if (t.getId() == taskId) {
                taskToDelete = t;
                break;
            }
        }

        // If found, delete it. If not, return not found!
        if (taskToDelete != null) {
            tasks.remove(taskToDelete);
            return new ApiResponse("Task Deleted Successfully!", "200");
        } else {
            return new ApiResponse("Task Not Found!", "404");
        }
    }

}
