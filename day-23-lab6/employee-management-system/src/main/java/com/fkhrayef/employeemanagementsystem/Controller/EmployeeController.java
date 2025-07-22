package com.fkhrayef.employeemanagementsystem.Controller;

import com.fkhrayef.employeemanagementsystem.Api.ApiResponse;
import com.fkhrayef.employeemanagementsystem.Model.Employee;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    ArrayList<Employee> employees = new ArrayList<>();

    @GetMapping("/get/employees")
    public ResponseEntity<?> getAllEmployees() {
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @PostMapping("/add/employee")
    public ResponseEntity<?> addEmployee(@Valid @RequestBody Employee employee, Errors errors) {
        // Check for validation errors
        if (errors.hasErrors()) {
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors()) {
                errorMessages.add(error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }
        // if ID already exists
        for (Employee e : employees) {
            if (e.getId().equals(employee.getId())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("ID already exists"));
            }
        }

        // Add employee
        employee.setOnLeave(false); // must be initially false
        employees.add(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @PutMapping("update/employees/{employeeId}")
    public ResponseEntity<?> updateEmployee(@PathVariable("employeeId") String employeeId, @Valid @RequestBody Employee employee, Errors errors) {
        // get the employee by his ID
        Employee employeeToUpdate = null;
        for (Employee e : employees) {
            if (e.getId().equals(employeeId)) {
                employeeToUpdate = e;
                break;
            }
        }

        if (employeeToUpdate == null) { // 404 if not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Employee not found!"));
        } else {
            // Check for validation errors
            if (errors.hasErrors()) { // 400 if validation failed
                ArrayList<String> errorMessages = new ArrayList<>();
                for (FieldError error : errors.getFieldErrors()) {
                    errorMessages.add(error.getDefaultMessage());
                }
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
            }

            // if ID already exists, and it's a different employee (We should allow updating the same employee id).
            for (Employee e : employees) {
                if (e.getId().equals(employee.getId()) && e != employeeToUpdate) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("ID already exists"));
                }
            }

            // Update employee
            employeeToUpdate.setId(employee.getId());
            employeeToUpdate.setName(employee.getName());
            employeeToUpdate.setEmail(employee.getEmail());
            employeeToUpdate.setPhoneNumber(employee.getPhoneNumber());
            employeeToUpdate.setAge(employee.getAge());
            employeeToUpdate.setPosition(employee.getPosition());
            employeeToUpdate.setOnLeave(employee.getOnLeave());
            employeeToUpdate.setHireDate(employee.getHireDate());
            employeeToUpdate.setAnnualLeave(employee.getAnnualLeave());
            return ResponseEntity.status(HttpStatus.OK).body(employeeToUpdate);
        }
    }

    @DeleteMapping("delete/employees/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("employeeId") String employeeId) {
        // get the employee by his ID
        Employee employeeToDelete = null;
        for (Employee e : employees) {
            if (e.getId().equals(employeeId)) {
                employeeToDelete = e;
                break;
            }
        }

        if (employeeToDelete == null) { // 404 if not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Employee not found!"));
        } else { // 204 and delete if found
            employees.remove(employeeToDelete);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse("Employee deleted successfully")); // the message won't show up.
        }
    }

    // I usually like putting endpoints in this order: GET -> POST -> PUT -> DELETE,
    // but for the sake of the lab, I will follow the lab's order

    @GetMapping("get/employees/position/{employeePosition}")
    public ResponseEntity<?> getEmployeesByPosition(@PathVariable("employeePosition") String employeePosition) {
        // Validate Path Variable
        if (!(employeePosition.equals("supervisor") || employeePosition.equals("coordinator"))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Position must be either supervisor or coordinator"));
        }

        // get employees
        ArrayList<Employee> filteredEmployees = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getPosition().equals(employeePosition))
                filteredEmployees.add(e);
        }

        if (filteredEmployees.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("No Employees match your criteria"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(filteredEmployees);
    }

    @GetMapping("get/employees/age-range")
    public ResponseEntity<?> getEmployeesByAgeRange(@RequestParam("minAge") Integer minAge, @RequestParam("maxAge") Integer maxAge) {
        // Validate age
        if (minAge > maxAge) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Min Age cannot be older than Max Age"));
        }
        if (minAge < 26) { // max age cannot be less than 26, so no need to validate it
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Age must be older than 25"));
        }

        // get employees
        ArrayList<Employee> filteredEmployees = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getAge() >= minAge && e.getAge() <= maxAge)
                filteredEmployees.add(e);
        }

        if (filteredEmployees.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("No Employees match your criteria"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(filteredEmployees);
    }

    @PutMapping("update/employees/apply-for-leave/{employeeId}")
    public ResponseEntity<?> applyForAnnualLeave(@PathVariable("employeeId") String employeeId) {
        // get the employee by his ID
        Employee employeeToUpdate = null;
        for (Employee e : employees) {
            if (e.getId().equals(employeeId)) {
                employeeToUpdate = e;
                break;
            }
        }

        // Validate Conditions
        if (employeeToUpdate == null) { // 404 if not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Employee not found!"));
        }
        if (employeeToUpdate.getOnLeave()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Employee is already on a leave"));
        }
        if (employeeToUpdate.getAnnualLeave() < 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Employee does not have annual leaves remaining"));
        }

        // Apply for a Leave
        employeeToUpdate.setOnLeave(true);
        employeeToUpdate.setAnnualLeave(employeeToUpdate.getAnnualLeave() - 1);
        return ResponseEntity.status(HttpStatus.OK).body(employeeToUpdate);
    }

    @GetMapping("get/employees/no-annual-leaves")
    public ResponseEntity<?> getAllEmployeesWithNoAnnualLeaves() {
        // get employees
        ArrayList<Employee> filteredEmployees = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getAnnualLeave() == 0)
                filteredEmployees.add(e);
        }

        if (filteredEmployees.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("No Employees match your criteria"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(filteredEmployees);
    }

    @PutMapping("update/employees/promote/{supervisorId}/{employeeId}")
    public ResponseEntity<?> promoteEmployee(@PathVariable("supervisorId") String supervisorId, @PathVariable("employeeId") String employeeId) {
        // get the supervisor by his ID
        Employee supervisor = null;
        for (Employee e : employees) {
            if (e.getId().equals(supervisorId)) {
                supervisor = e;
                break;
            }
        }
        if (supervisor == null) { // 404 if not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Supervisor not found!"));
        }

        // get the employee by his ID
        Employee employeeToUpdate = null;
        for (Employee e : employees) {
            if (e.getId().equals(employeeId)) {
                employeeToUpdate = e;
                break;
            }
        }
        if (employeeToUpdate == null) { // 404 if not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Employee not found!"));
        }

        // Validate Conditions
        if (!supervisor.getPosition().equals("supervisor")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Requester must be a supervisor"));
        }
        if (employeeToUpdate.getAge() < 30) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Employee must be at least 30 years old"));
        }
        if (employeeToUpdate.getOnLeave()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Employee is already on a leave"));
        }
        if (employeeToUpdate.getPosition().equals("supervisor")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Employee is already a supervisor"));
        }

        // Promote Employee
        employeeToUpdate.setPosition("supervisor");
        return ResponseEntity.status(HttpStatus.OK).body(employeeToUpdate);
    }
}
