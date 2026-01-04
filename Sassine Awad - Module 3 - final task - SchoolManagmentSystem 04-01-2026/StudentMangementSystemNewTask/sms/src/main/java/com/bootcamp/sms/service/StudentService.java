package com.bootcamp.sms.service;

import com.bootcamp.sms.dto.StudentDTO;
import java.util.List;

public interface StudentService {
    void saveStudent(StudentDTO studentDTO);
    List<StudentDTO> getAllStudents();
    StudentDTO getStudentById(Long id);
    void deleteStudent(Long id);
    List<StudentDTO> searchStudents(String keyword);
}