package com.fkhrayef.learningmanagementsystem.Controller;

import com.fkhrayef.learningmanagementsystem.Api.ApiResponse;
import com.fkhrayef.learningmanagementsystem.Model.Course;
import com.fkhrayef.learningmanagementsystem.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity<?> getCourses() {
        ArrayList<Course> courses = courseService.getCourses();

        if (!courses.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(courses);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No courses yet. Try adding some!"));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@Valid @RequestBody Course course, Errors errors) {
        // Check for validation errors
        if (errors.hasErrors()) {
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors())
                errorMessages.add(error.getDefaultMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        // add course
        courseService.addCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable("id") String id, @Valid @RequestBody Course course, Errors errors) {
        // Check for validation errors
        if (errors.hasErrors()) {
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors())
                errorMessages.add(error.getDefaultMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        if (courseService.updateCourse(id, course))
            return ResponseEntity.status(HttpStatus.OK).body(course);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Course not found!"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable("id") String id) {
        if (courseService.deleteCourse(id))
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse("Deleted")); // the message won't show up because status is 204 NO CONTENT
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Course not found!"));

    }

    @GetMapping("/get/search-by-title")
    public ResponseEntity<?> getCourseByTitle(@RequestParam("title") String title) {
        Course course = courseService.getCourseByTitle(title);
        if (course != null)
            return ResponseEntity.status(HttpStatus.OK).body(course);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Course not found!"));
    }

    @GetMapping("/get/search-by-instructor")
    public ResponseEntity<?> getCoursesByInstructor(@RequestParam("instructor") String instructor) {
        ArrayList<Course> filteredCourses = courseService.getCoursesByInstructor(instructor);

        if (!filteredCourses.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(filteredCourses);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No courses meet your criteria"));
    }

    @GetMapping("/get/search-by-difficulty")
    public ResponseEntity<?> getCoursesByDifficulty(@RequestParam("difficulty") String difficulty) {
        ArrayList<Course> filteredCourses = courseService.getCoursesByDifficulty(difficulty);

        // if the difficulty is wrong
        if (filteredCourses == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Invalid Difficulty"));

        if (!filteredCourses.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(filteredCourses);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No courses meet your criteria"));
    }

    @PutMapping("/update/toggle-difficulty/{instructorId}/{courseId}")
    public ResponseEntity<?> toggleDifficulty(@PathVariable("instructorId") String instructorId, @PathVariable("courseId") String courseId) {
        Integer status = courseService.toggleDifficulty(instructorId, courseId);

        if (status == 1)
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Course difficulty toggled successfully"));
        else if (status == 2)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Course not found!"));
        else if (status == 3)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Instructor doesn't have permissions"));
        else if (status == 4)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Instructor not found!"));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Oops! Something went wrong. Try Again"));
    }
}
