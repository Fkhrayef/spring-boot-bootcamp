package com.fkhrayef.schoolmanagementsystem.Controller;

import com.fkhrayef.schoolmanagementsystem.Api.ApiResponse;
import com.fkhrayef.schoolmanagementsystem.Model.Teacher;
import com.fkhrayef.schoolmanagementsystem.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllTeachers(){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getAllTeachers());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTeacherById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getTeacherById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@Valid @RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Teacher added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Integer id, @Valid @RequestBody Teacher teacher){
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Teacher updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
