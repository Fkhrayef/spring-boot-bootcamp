package com.fkhrayef.learningmanagementsystem.Service;

import com.fkhrayef.learningmanagementsystem.Model.Course;
import com.fkhrayef.learningmanagementsystem.Model.Instructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final InstructorService instructorService;

    ArrayList<Course> courses = new ArrayList<>();

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public Boolean updateCourse(String id, Course course) {
        // Look for the course and update it if found
        for (int i = 0; i < courses.size() ; i++) {
            if (courses.get(i).getId().equals(id)) {
                courses.set(i, course);
                return true;
            }
        }
        // if not found, return false
        return false;
    }

    public Boolean deleteCourse(String id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId().equals(id)) {
                courses.remove(i);
                return true;
            }
        }
        return false;
    }

    public Course getCourseByTitle(String title) {
        // Look for the course and return it if found
        for (Course course : courses) {
            if (course.getTitle().equalsIgnoreCase(title))
                return course;
        }
        // if not found, return null
        return null;
    }

    public ArrayList<Course> getCoursesByInstructor(String instructor) {
        ArrayList<Course> filteredCourses = new ArrayList<>();

        for (Course course : courses) {
            if (course.getInstructor().equals(instructor))
                filteredCourses.add(course);
        }

        return filteredCourses;
    }

    public ArrayList<Course> getCoursesByDifficulty(String difficulty) {
        // if difficulty is wrong return null
        if (!(difficulty.equals("Easy") || difficulty.equals("Hard")))
            return null;

        ArrayList<Course> filteredCourses = new ArrayList<>();

        for (Course course : courses) {
            if (course.getDifficulty().equals(difficulty))
                filteredCourses.add(course);
        }

        return filteredCourses;
    }

    public Integer toggleDifficulty(String instructorId, String courseId) {
        for (Instructor instructor : instructorService.getInstructors()) {
            if (instructor.getId().equals(instructorId)) {
                if (instructor.getRank().equals("Professor")) {
                    for (Course course : courses) {
                        if (course.getId().equals(courseId)) {
                            if (course.getDifficulty().equals("Easy"))
                                course.setDifficulty("Hard");
                            else
                                course.setDifficulty("Easy");
                            return 1; // updated successfully
                        }
                    }
                    return 2; // course not found
                }
                return 3; // instructor doesn't have permissions
            }
        }
        return 4; // instructor not found
    }
}
