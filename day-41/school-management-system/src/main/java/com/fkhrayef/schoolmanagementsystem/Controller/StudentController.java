package com.fkhrayef.schoolmanagementsystem.Controller;

import com.fkhrayef.schoolmanagementsystem.Api.ApiResponse;
import com.fkhrayef.schoolmanagementsystem.Model.Student;
import com.fkhrayef.schoolmanagementsystem.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllStudents(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@Valid @RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Student added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id, @Valid @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Student updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}/enroll/{courseId}")
    public ResponseEntity<?> enrollToCourse(@PathVariable Integer id, @PathVariable Integer courseId) {
        studentService.enrollToCourse(id, courseId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Student enrolled to course successfully"));
    }

    @PutMapping("/{id}/switch-major/{major}")
    public ResponseEntity<?> switchMajor(@PathVariable Integer id, @PathVariable String major) {
        studentService.switchMajor(id, major);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Major switched successfully"));
    }
}
