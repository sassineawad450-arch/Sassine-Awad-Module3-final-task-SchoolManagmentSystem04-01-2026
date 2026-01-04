package com.bootcamp.sms.service;

import com.bootcamp.sms.dto.CourseDTO;
import com.bootcamp.sms.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.JdbcAggregateOperations;

import java.util.List;
public interface CourseService {

    CourseDTO createCourse(CourseDTO courseDTO);

    boolean existsByCourseCode (String code);
    List<CourseDTO> getAllCourses();
    void deleteCourse(Long id);
    CourseDTO getCourseById(Long id);
    List<CourseDTO> searchCourses(String keyword);
}
