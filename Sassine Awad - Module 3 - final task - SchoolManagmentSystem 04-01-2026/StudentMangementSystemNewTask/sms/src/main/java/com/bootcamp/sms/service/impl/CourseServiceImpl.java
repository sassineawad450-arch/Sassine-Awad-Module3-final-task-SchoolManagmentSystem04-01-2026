package com.bootcamp.sms.service.impl;

import com.bootcamp.sms.dto.CourseDTO;
import com.bootcamp.sms.model.Courses;
import com.bootcamp.sms.repository.CourseRepository;
import com.bootcamp.sms.service.CourseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;
//@Service
//@Transactional
/*public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper mapper;
    CourseServiceImpl(CourseRepository courseRepository, ModelMapper mapper) {
        this.courseRepository = courseRepository;
        this.mapper = mapper;
    }
    @Override
    public CourseDTO createCourse(CourseDTO courseDTO){
        Courses courses = mapper.map(courseDTO, Courses.class);
        courseRepository.save(courses);
        return mapper.map(courses, CourseDTO.class);
    }

    @Override
    public boolean existsByCourseCode(String code) {
        return courseRepository.existsByCourseCodeIgnoreCase(code);
    }
}*/

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    private final CourseRepository courseRepository;
    private final ModelMapper mapper;
    @Autowired // هذا السطر هو الحل!
    private ModelMapper modelMapper;

    // Constructor Injection (Best practice for Spring)
    public CourseServiceImpl(CourseRepository courseRepository, ModelMapper mapper) {
        this.courseRepository = courseRepository;
        this.mapper = mapper;
    }

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        // Step 1: Map DTO to Entity
        Courses courseEntity = mapper.map(courseDTO, Courses.class);

        // Step 2: Save to Database
        Courses savedCourse = courseRepository.save(courseEntity);

        // Step 3: Map saved Entity back to DTO for the response
        return mapper.map(savedCourse, CourseDTO.class);
    }

    @Override
    public boolean existsByCourseCode(String code) {
        // This matches the repository method name
        return courseRepository.existsByCourseCodeIgnoreCase(code);
    }
    public List<CourseDTO> getAllCourses() {
        List<Courses> coursesList = courseRepository.findAll();
        return coursesList.stream()
                .map(course -> mapper.map(course, CourseDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    public void deleteCourse(Long id) {
        // نتحقق أولاً هل الكورس موجود أم لا قبل الحذف لضمان عدم حدوث خطأ
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
        } else {
            throw new RuntimeException("Course not found with id: " + id);
        }
    }
    @Override
    public CourseDTO getCourseById(Long id) {
        Courses course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return modelMapper.map(course, CourseDTO.class);
    }
    @Override
    public List<CourseDTO> searchCourses(String keyword) {
        List<Courses> courses = courseRepository.findByCourseNameContainingIgnoreCase(keyword);
        return courses.stream()
                .map(course -> modelMapper.map(course, CourseDTO.class))
                .collect(Collectors.toList());
    }
}
