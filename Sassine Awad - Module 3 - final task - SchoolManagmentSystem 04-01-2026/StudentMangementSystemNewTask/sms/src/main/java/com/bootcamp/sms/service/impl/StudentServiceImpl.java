package com.bootcamp.sms.service.impl;

import com.bootcamp.sms.dto.StudentDTO;
import com.bootcamp.sms.model.Courses;
import com.bootcamp.sms.model.Students;
import com.bootcamp.sms.repository.CourseRepository;
import com.bootcamp.sms.repository.StudentRepository;
import com.bootcamp.sms.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveStudent(StudentDTO studentDTO) {
        Students student = modelMapper.map(studentDTO, Students.class);

        // تحويل التاريخ من String إلى LocalDate
        if (studentDTO.getDateOfBirth() != null && !studentDTO.getDateOfBirth().isEmpty()) {
            student.setDateOfBirth(LocalDate.parse(studentDTO.getDateOfBirth()));
        }

        // ربط الطالب بالكورس المختار
        if (studentDTO.getCourseId() != null) {
            Courses course = courseRepository.findById(studentDTO.getCourseId())
                    .orElseThrow(() -> new RuntimeException("Course not found"));
            student.setSelectedCourse(course);
        }

        studentRepository.save(student);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Students student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        StudentDTO dto = convertToDTO(student);
        if (student.getSelectedCourse() != null) {
            dto.setCourseId(student.getSelectedCourse().getId());
        }
        return dto;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<StudentDTO> searchStudents(String keyword) {
        return studentRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrPhoneNumberContaining(keyword, keyword, keyword)
                .stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private StudentDTO convertToDTO(Students student) {
        StudentDTO dto = modelMapper.map(student, StudentDTO.class);
        if (student.getSelectedCourse() != null) {
            dto.setCourseName(student.getSelectedCourse().getCourseName());
        }
        if (student.getDateOfBirth() != null) {
            dto.setDateOfBirth(student.getDateOfBirth().toString());
        }
        return dto;
    }
}