package com.bootcamp.sms.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "students")
@Data
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String fatherName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private String identityNumber; // رقم السجل حسب الهوية
    private String district;       // القضاء
    private String governorate;    // المحافظة
    private String town;           // البلدة

    // مكان السكن بالتفصيل
    private String buildingName;
    private String buildingNumber;
    private String buildingOwner;
    private String floor;
    private String houseOwner;
    @Column(length = 500)
    private String detailedAddress;

    private String phoneNumber;

    // الربط مع الكورس (علاقة كثير لواحد)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Courses selectedCourse;

    private Double amountPaid;
}