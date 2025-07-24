package com.fkhrayef.learningmanagementsystem.Service;

import com.fkhrayef.learningmanagementsystem.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;

@Service
public class StudentService {
    ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Boolean updateStudent(String id, Student student) {
        // Look for the student and update it if found
        for (int i = 0; i < students.size() ; i++) {
            if (students.get(i).getId().equals(id)) {
                students.set(i, student);
                return true;
            }
        }
        // if not found, return false
        return false;
    }

    public Boolean deleteStudent(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public Student getStudentByName(String name) {
        // Look for the student and return it if found
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name))
                return student;
        }
        // if not found, return null
        return null;
    }

    public ArrayList<Student> getByLevel(Integer level) {
        ArrayList<Student> filteredStudents = new ArrayList<>();

        for (Student student : students) {
            if (student.getLevel().equals(level))
                filteredStudents.add(student);
        }

        return filteredStudents;
    }

    public ArrayList<Student> getLeaderboard() {
        ArrayList<Student> filteredStudents = new ArrayList<>(students);

        filteredStudents.sort(Comparator.comparingDouble(Student::getGpa).reversed());

        return filteredStudents;
    }

    public ArrayList<Student> getStudentsByDepartment(String department) {
        // if department is wrong return null
        if (!(department.equals("Computer Science") || department.equals("Business")))
            return null;

        ArrayList<Student> filteredStudents = new ArrayList<>();

        for (Student student : students) {
            if (student.getDepartment().equals(department))
                filteredStudents.add(student);
        }

        return filteredStudents;
    }
}
