package com.studentsys.service;

import com.studentsys.domain.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);

    List<Student> findAllStudents();

    Student findStudentById(Long id);

    Student updateStudent(Student student);

    void deleteStudent(Long id);
}
