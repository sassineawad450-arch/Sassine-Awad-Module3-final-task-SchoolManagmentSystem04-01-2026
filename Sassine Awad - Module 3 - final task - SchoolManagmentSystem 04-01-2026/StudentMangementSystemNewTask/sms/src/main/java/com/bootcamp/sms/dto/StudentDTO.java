package com.bootcamp.sms.dto;

import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    private String firstName;
    private String fatherName;
    private String lastName;
    private String dateOfBirth; // سنستقبله كنص من الـ HTML ونحوله في الـ Service
    private String placeOfBirth;
    private String identityNumber;
    private String district;
    private String governorate;
    private String town;
    private String buildingName;
    private String buildingNumber;
    private String buildingOwner;
    private String floor;
    private String houseOwner;
    private String detailedAddress;
    private String phoneNumber;

    private Long courseId;      // لاستقبال اختيار الكورس من القائمة المنسدلة
    private String courseName;  // لعرض اسم الكورس في الجداول
    private Double amountPaid;
}