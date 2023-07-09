package com.studentsys.service.implementation;

import com.studentsys.domain.Student;
import com.studentsys.exception.StudentNotFoundException;
import com.studentsys.repository.StudentRepo;
import com.studentsys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Student addStudent(Student student) {
        student.setStudentId(UUID.randomUUID().toString());
        return studentRepo.save(student);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student findStudentById(Long id) {
        return studentRepo.findStudentById(id).orElseThrow(
                () -> new StudentNotFoundException("User by ID: " + id + " could not be found!"));
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteStudentById(id);
    }

}

















