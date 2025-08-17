package com.fkhrayef.schoolmanagementsystem.Service;

import com.fkhrayef.schoolmanagementsystem.Api.ApiException;
import com.fkhrayef.schoolmanagementsystem.DTO.CourseDTO;
import com.fkhrayef.schoolmanagementsystem.Model.Course;
import com.fkhrayef.schoolmanagementsystem.Model.Student;
import com.fkhrayef.schoolmanagementsystem.Model.Teacher;
import com.fkhrayef.schoolmanagementsystem.Repository.CourseRepository;
import com.fkhrayef.schoolmanagementsystem.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Integer id, Course course){
        Course oldCourse = courseRepository.findCourseById(id);
        if (oldCourse == null) {
            throw new ApiException("Course not found");
        }

        oldCourse.setName(course.getName());
        courseRepository.save(oldCourse);
    }

    public void deleteCourse(Integer id){
        Course course = courseRepository.findCourseById(id);
        if (course == null) {
            throw new ApiException("Course not found");
        }

        courseRepository.delete(course);
    }

    public void assignTeacherToCourse(Integer courseId, Integer teacherId){
        Course course = courseRepository.findCourseById(courseId);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public CourseDTO getTeacherNameByCourseId(Integer courseId) {
        Course course = courseRepository.findCourseById(courseId);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        Teacher teacher = course.getTeacher();
        if (teacher == null) {
            throw new ApiException("No teacher assigned to this course");
        }

        return new CourseDTO(teacher.getName());
    }

    public Set<Student> getStudentsOfCourse(Integer courseId){
        Course course = courseRepository.findCourseById(courseId);
        if (course == null) {
            throw new ApiException("Course not found");
        }

        return course.getStudents();
    }
}
