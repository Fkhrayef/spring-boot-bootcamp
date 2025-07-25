package com.fkhrayef.student.Controller;

import com.fkhrayef.student.Api.ApiResponse;
import com.fkhrayef.student.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/")
public class StudentController {

    ArrayList<Student> students = new ArrayList<>();

    @GetMapping("get/students")
    public ArrayList<Student> getStudents(){
        return students;
    }

    @GetMapping("get/students/{studentId}/honors-classification")
    public ApiResponse getStudentDegree(@PathVariable int studentId){
        Student student = null;
        for (Student s : students) {
            if (s.getId() == studentId) {
                student = s;
                break;
            }
        }
        if (student == null) {
            return new ApiResponse("Student not found", "error");
        } else {
            return new ApiResponse(student.getDegree(), "success");
        }
    }

    @GetMapping("get/students/above-average")
    public ArrayList<Student> getAboveAverage(){
        ArrayList<Student> aboveAverage = new ArrayList<>();

        // Calculate Average GPA
        double sum = 0;
        int total = students.size();

        for (Student s : students) {
            sum += s.getGPA();
        }
        double average = sum / total;

        // Get Students with GPA > Average
        for (Student s : students) {
            if (s.getGPA() >= average) {
                aboveAverage.add(s);
            }
        }
        return aboveAverage;
    }

    @PostMapping("add/student")
    public ApiResponse addStudent(@RequestBody Student student){
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                return new ApiResponse("Student ID Already Exists!", "400");
            }
        }
        String degree = student.getGPA() >= 4.75 ? "First Honors" : student.getGPA() >= 4.25 ? "Second Honors" : "N/A";
        students.add(new Student(student.getId(), student.getName(), student.getAge(), degree, student.getGPA()));
        return new ApiResponse("Student Added Successfully!", "200");
    }

    @PutMapping("update/students/{studentId}")
    public ApiResponse updateStudent(@PathVariable int studentId, @RequestBody Student student){
        // Get the student by their id
        Student studentToUpdate = null;
        for (Student s : students) {
            if (s.getId() == studentId) {
                studentToUpdate = s;
                break;
            }
        }

        // If found, update it. If not, return not found!
        if (studentToUpdate == null) {
            return new ApiResponse("Student not found", "error");
        } else {
            studentToUpdate.setName(student.getName());
            studentToUpdate.setAge(student.getAge());
            studentToUpdate.setDegree(student.getDegree());
            studentToUpdate.setGPA(student.getGPA());
            return new ApiResponse("Student updated successfully", "success");
        }
    }

    // this was an endpoint to classify students into honors categories
    // now it's automatically done through addStudent endpoint.
//    @PutMapping("/honors-classification")
//    public ArrayList<Student> classifyStudents(){
//        for (Student s : students) {
//            if (s.getGPA() >= 4.75) {
//                s.setDegree("First Honors");
//            } else if (s.getGPA() >= 4.25) {
//                s.setDegree("Second Honors");
//            } else {
//                s.setDegree("N/A");
//            }
//        }
//        return students;
//    }

    @DeleteMapping("delete/students/{studentId}")
    public ApiResponse deleteStudent(@PathVariable int studentId){
        // Get the student by their id
        Student studentToDelete = null;
        for (Student s : students) {
            if (s.getId() == studentId) {
                studentToDelete = s;
                break;
            }
        }

        // If found, delete it. If not, return not found!
        if (studentToDelete == null) {
            return new ApiResponse("Student not found", "error");
        } else {
            students.remove(studentToDelete);
            return new ApiResponse("Student deleted successfully", "success");
        }
    }
}
