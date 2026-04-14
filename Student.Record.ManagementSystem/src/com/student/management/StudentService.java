package com.student.management;

import java.util.*;

public class StudentService {
    private Map<Integer, Student> studentMap = new HashMap<>();

    public void addStudent(Student student) {
        studentMap.put(student.getId(), student);
        System.out.println("Student added successfully.");
    }

    public void viewAllStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        for (Student s : studentMap.values()) {
            System.out.println(s);
        }
    }

    public void updateStudent(int id, String name, double marks) {
        Student s = studentMap.get(id);
        if (s != null) {
            s.setName(name);
            s.setMarks(marks);
            System.out.println("Student record updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void deleteStudent(int id) {
        if (studentMap.remove(id) != null) {
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }
}

