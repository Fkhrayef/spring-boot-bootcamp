package com.fkhrayef.schoolmanagementsystem.Controller;

import com.fkhrayef.schoolmanagementsystem.Api.ApiResponse;
import com.fkhrayef.schoolmanagementsystem.Model.Course;
import com.fkhrayef.schoolmanagementsystem.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllCourses(){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getAllCourses());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@Valid @RequestBody Course course) {
        courseService.addCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Course added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id, @Valid @RequestBody Course course) {
        courseService.updateCourse(id, course);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Course updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/assign/{courseId}/{teacherId}")
    public ResponseEntity<?> assignTeacherToCourse(@PathVariable Integer courseId, @PathVariable Integer teacherId) {
        courseService.assignTeacherToCourse(courseId, teacherId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Teacher assigned to course successfully"));
    }

    @GetMapping("/{courseId}/teacher")
    public ResponseEntity<?> getTeacherNameByCourseId(@PathVariable Integer courseId) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getTeacherNameByCourseId(courseId));
    }

    @GetMapping("/{courseId}/students")
    public ResponseEntity<?> getStudentsOfCourse(@PathVariable Integer courseId) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getStudentsOfCourse(courseId));
    }
}
