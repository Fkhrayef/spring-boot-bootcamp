package com.fkhrayef.schoolmanagementsystem.Service;

import com.fkhrayef.schoolmanagementsystem.Api.ApiException;
import com.fkhrayef.schoolmanagementsystem.Model.Course;
import com.fkhrayef.schoolmanagementsystem.Model.Student;
import com.fkhrayef.schoolmanagementsystem.Repository.CourseRepository;
import com.fkhrayef.schoolmanagementsystem.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Integer id, Student student){
        Student oldStudent = studentRepository.findStudentById(id);
        if (oldStudent == null) {
            throw new ApiException("Student not found");
        }

        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        oldStudent.setMajor(student.getMajor());
        studentRepository.save(oldStudent);
    }

    public void deleteStudent(Integer id){
        Student student = studentRepository.findStudentById(id);
        if (student == null) {
            throw new ApiException("Student not found");
        }

        studentRepository.delete(student);
    }

    public void enrollToCourse(Integer studentId, Integer courseId){
        Student student = studentRepository.findStudentById(studentId);
        if (student == null) {
            throw new ApiException("Student not found");
        }
        Course course = courseRepository.findCourseById(courseId);
        if (course == null) {
            throw new ApiException("Course not found");
        }

        student.getCourses().add(course);
        course.getStudents().add(student);
        studentRepository.save(student);
    }

    public void switchMajor(Integer id, String major){
        Student student = studentRepository.findStudentById(id);
        if (student == null) {
            throw new ApiException("Student not found");
        }
        if (student.getMajor().equals(major)) {
            throw new ApiException("Student already in this major");
        }

        for (Course course : student.getCourses()) {
            course.getStudents().remove(student);
            courseRepository.save(course);
        }

        student.setMajor(major);
        studentRepository.save(student);
    }
}
