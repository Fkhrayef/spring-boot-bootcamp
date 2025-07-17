package com.fkhrayef.day20.Controller;

import com.fkhrayef.day20.Model.Task;
import com.fkhrayef.day20.response.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {

    ArrayList<Task> tasks = new ArrayList<>();

    @GetMapping("")
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @GetMapping("/{taskId}")
    public Task getTask(@PathVariable("taskId") int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                return task;
            }
        }
        return null;
    }

    @GetMapping("/search")
    public ArrayList<Task> searchTasks(@RequestParam("query") String query) {
        ArrayList<Task> candidates = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getTitle().toLowerCase().contains(query.toLowerCase())) {
                candidates.add(task);
            }
        }
        return candidates;
    }

    @PostMapping("")
    public ApiResponse addTask(@RequestBody Task task) {
        int id = 1;
        if (!tasks.isEmpty()) {
            id = tasks.get(tasks.size() - 1).getId() + 1;
        }
        tasks.add(new Task(id, task.getTitle(), task.getDescription(), task.isStatus()));
        return new ApiResponse("Task Added Successfully!", "200");
    }

    @PutMapping("/{taskId}")
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

    @DeleteMapping("/{taskId}")
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
