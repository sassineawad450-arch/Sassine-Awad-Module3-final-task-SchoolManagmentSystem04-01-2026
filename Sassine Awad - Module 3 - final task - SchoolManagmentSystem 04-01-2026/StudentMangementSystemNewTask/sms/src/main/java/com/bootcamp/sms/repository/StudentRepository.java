package com.bootcamp.sms.repository;

import com.bootcamp.sms.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long> {
    // ميثود البحث بالاسم الأول أو اسم العائلة أو رقم الهاتف
    List<Students> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrPhoneNumberContaining(String firstName, String lastName, String phone);
}