package com.fkhrayef.learningmanagementsystem.Controller;

import com.fkhrayef.learningmanagementsystem.Api.ApiResponse;
import com.fkhrayef.learningmanagementsystem.Model.Instructor;
import com.fkhrayef.learningmanagementsystem.Service.InstructorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/instructors")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorService instructorService;

    @GetMapping("/get")
    public ResponseEntity<?> getInstructors() {
        ArrayList<Instructor> instructors = instructorService.getInstructors();

        if (!instructors.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(instructors);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No instructors yet. Try adding some!"));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addInstructor(@Valid @RequestBody Instructor instructor, Errors errors) {
        // Check for validation errors
        if (errors.hasErrors()) {
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors())
                errorMessages.add(error.getDefaultMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        // add instructor
        instructorService.addInstructor(instructor);
        return ResponseEntity.status(HttpStatus.CREATED).body(instructor);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateInstructor(@PathVariable("id") String id, @Valid @RequestBody Instructor instructor, Errors errors) {
        // Check for validation errors
        if (errors.hasErrors()) {
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors())
                errorMessages.add(error.getDefaultMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        if (instructorService.updateInstructor(id, instructor))
            return ResponseEntity.status(HttpStatus.OK).body(instructor);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Instructor not found!"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteInstructor(@PathVariable("id") String id) {
        if (instructorService.deleteInstructor(id))
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse("Deleted")); // the message won't show up because status is 204 NO CONTENT
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Instructor not found!"));
    }

    @GetMapping("/get/search-by-name")
    public ResponseEntity<?> getInstructorByName(@RequestParam("name") String name) {
        Instructor instructor = instructorService.getInstructorByName(name);
        if (instructor != null)
            return ResponseEntity.status(HttpStatus.OK).body(instructor);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Instructor not found!"));
    }

    @GetMapping("/get/search-by-specialization")
    public ResponseEntity<?> getInstructorsBySpecialization(@RequestParam("specialization") String specialization) {
        ArrayList<Instructor> filteredInstructors = instructorService.getInstructorsBySpecialization(specialization);

        // if the specialization is wrong
        if (filteredInstructors == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Invalid Specialization"));

        if (!filteredInstructors.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(filteredInstructors);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No instructors meet your criteria"));
    }

    @GetMapping("/get/search-by-rank")
    public ResponseEntity<?> getInstructorsByRank(@RequestParam("rank") String rank) {
        ArrayList<Instructor> filteredInstructors = instructorService.getInstructorsByRank(rank);

        // if the rank is wrong
        if (filteredInstructors == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Invalid Rank"));

        if (!filteredInstructors.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(filteredInstructors);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No instructors meet your criteria"));
    }

    @GetMapping("/get/search-by-department")
    public ResponseEntity<?> getInstructorsByDepartment(@RequestParam("department") String department) {
        ArrayList<Instructor> filteredInstructors = instructorService.getInstructorsByDepartment(department);

        // if the department is wrong
        if (filteredInstructors == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Invalid Department"));

        if (!filteredInstructors.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(filteredInstructors);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No instructors meet your criteria"));
    }
}
