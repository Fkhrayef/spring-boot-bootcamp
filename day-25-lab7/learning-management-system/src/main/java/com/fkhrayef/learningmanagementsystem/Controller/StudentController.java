package com.fkhrayef.learningmanagementsystem.Controller;

import com.fkhrayef.learningmanagementsystem.Api.ApiResponse;
import com.fkhrayef.learningmanagementsystem.Model.Student;
import com.fkhrayef.learningmanagementsystem.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity<?> getStudents() {
        ArrayList<Student> students = studentService.getStudents();

        if (!students.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(students);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No students yet. Try adding some!"));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@Valid @RequestBody Student student, Errors errors) {
        // Check for validation errors
        if (errors.hasErrors()) {
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors())
                errorMessages.add(error.getDefaultMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        // add student
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") String id, @Valid @RequestBody Student student, Errors errors) {
        // Check for validation errors
        if (errors.hasErrors()) {
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors())
                errorMessages.add(error.getDefaultMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        if (studentService.updateStudent(id, student))
            return ResponseEntity.status(HttpStatus.OK).body(student);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Student not found!"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") String id) {
        if (studentService.deleteStudent(id))
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse("Deleted")); // the message won't show up because status is 204 NO CONTENT
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Student not found!"));
    }

    @GetMapping("/get/search-by-name")
    public ResponseEntity<?> getStudentByName(@RequestParam("name") String name) {
        Student student = studentService.getStudentByName(name);
        if (student != null)
            return ResponseEntity.status(HttpStatus.OK).body(student);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Student not found!"));
    }

    @GetMapping("/get/level")
    public ResponseEntity<?> getByLevel(@RequestParam("level") Integer level) {
        ArrayList<Student> filteredStudents = studentService.getByLevel(level);

        if (!filteredStudents.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(filteredStudents);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No students meet your criteria!"));
    }

    @GetMapping("/get/leaderboard")
    public ResponseEntity<?> getLeaderboard() {
        ArrayList<Student> leaderboard = studentService.getLeaderboard();

        if (!leaderboard.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(leaderboard);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No students found!"));
    }

    @GetMapping("/get/search-by-department")
    public ResponseEntity<?> getStudentsByDepartment(@RequestParam("department") String department) {
        ArrayList<Student> filteredStudents = studentService.getStudentsByDepartment(department);

        // if the department is wrong
        if (filteredStudents == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Invalid Department"));

        if (!filteredStudents.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(filteredStudents);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No students meet your criteria"));
    }
}
