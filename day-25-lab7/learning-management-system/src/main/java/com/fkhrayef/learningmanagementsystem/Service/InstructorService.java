package com.fkhrayef.learningmanagementsystem.Service;

import com.fkhrayef.learningmanagementsystem.Model.Instructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InstructorService {
    ArrayList<Instructor> instructors = new ArrayList<>();

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }

    public Boolean updateInstructor(String id, Instructor instructor) {
        // Look for the instructor and update it if found
        for (int i = 0; i < instructors.size() ; i++) {
            if (instructors.get(i).getId().equals(id)) {
                instructors.set(i, instructor);
                return true;
            }
        }
        // if not found, return false
        return false;
    }

    public Boolean deleteInstructor(String id) {
        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getId().equals(id)) {
                instructors.remove(i);
                return true;
            }
        }
        return false;
    }

    public Instructor getInstructorByName(String name) {
        // Look for the instructor and return it if found
        for (Instructor instructor : instructors) {
            if (instructor.getName().equalsIgnoreCase(name))
                return instructor;
        }
        // if not found, return null
        return null;
    }

    public ArrayList<Instructor> getInstructorsBySpecialization(String specialization) {
        // if specialization is wrong return null
        if (!(specialization.equals("AI") || specialization.equals("Networks")))
            return null;

        ArrayList<Instructor> filteredInstructors = new ArrayList<>();

        for (Instructor instructor : instructors) {
            if (instructor.getSpecialization().equals(specialization))
                filteredInstructors.add(instructor);
        }

        return filteredInstructors;
    }

    public ArrayList<Instructor> getInstructorsByRank(String rank) {
        // if rank is wrong return null
        if (!(rank.equals("Professor") || rank.equals("Lecturer")))
            return null;

        ArrayList<Instructor> filteredInstructors = new ArrayList<>();

        for (Instructor instructor : instructors) {
            if (instructor.getRank().equals(rank))
                filteredInstructors.add(instructor);
        }

        return filteredInstructors;
    }

    public ArrayList<Instructor> getInstructorsByDepartment(String department) {
        // if department is wrong return null
        if (!(department.equals("Computer Science") || department.equals("Business")))
            return null;

        ArrayList<Instructor> filteredInstructors = new ArrayList<>();

        for (Instructor instructor : instructors) {
            if (instructor.getDepartment().equals(department))
                filteredInstructors.add(instructor);
        }

        return filteredInstructors;
    }

}
