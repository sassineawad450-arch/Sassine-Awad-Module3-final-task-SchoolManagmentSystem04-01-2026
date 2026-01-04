package com.bootcamp.sms.repository;

import com.bootcamp.sms.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository <Courses, Long> {


    // ميثود البحث عن اسم الكورس
    List<Courses> findByCourseNameContainingIgnoreCase(String keyword);

    boolean existsByCourseCodeIgnoreCase(String code);

}
