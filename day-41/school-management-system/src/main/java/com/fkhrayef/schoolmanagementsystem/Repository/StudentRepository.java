package com.fkhrayef.schoolmanagementsystem.Repository;

import com.fkhrayef.schoolmanagementsystem.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findStudentById(Integer id);
}
