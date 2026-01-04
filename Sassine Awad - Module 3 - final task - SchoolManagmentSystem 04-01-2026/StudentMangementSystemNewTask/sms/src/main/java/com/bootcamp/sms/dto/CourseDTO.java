package com.bootcamp.sms.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CourseDTO {

    private Long id;

    @NotBlank(message = "Course name is required.")
    @Size(max =150,message ="Max of 150 characters allowed")
    private String courseName;

    @NotBlank(message = "Course code is required.")
    private String courseCode;

    @NotBlank(message = "Course duration is required.")
    private String duration;


    private boolean active;

    //@NotNull(message = "Course fee is required.")
   // private BigDecimal fee;
    @NotNull(message = "Course fee is required.") // ✅ هذا هو التعديل المطلوب
    //@DecimalMin(value = "0.0", inclusive = true, message = "Fee must be positive")
    private BigDecimal fee;

    @Size(max =500,message ="Max of 500 characters allowed")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Course name is required.") @Size(max = 150, message = "Max of 150 characters allowed") String getCourseName() {
        return courseName;
    }

    public void setCourseName(@NotBlank(message = "Course name is required.") @Size(max = 150, message = "Max of 150 characters allowed") String courseName) {
        this.courseName = courseName;
    }

    public @NotBlank(message = "Course code is required.") String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(@NotBlank(message = "Course code is required.") String courseCode) {
        this.courseCode = courseCode;
    }

    public @NotBlank(message = "Course duration is required.") String getDuration() {
        return duration;
    }

    public void setDuration(@NotBlank(message = "Course duration is required.") String duration) {
        this.duration = duration;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public @NotNull(message = "Course fee is required.") BigDecimal getFee() {
        return fee;
    }

    public void setFee(@NotNull(message = "Course fee is required.") BigDecimal fee) {
        this.fee = fee;
    }

    public @Size(max = 500, message = "Max of 500 characters allowed") String getDescription() {
        return description;
    }

    public void setDescription(@Size(max = 500, message = "Max of 500 characters allowed") String description) {
        this.description = description;
    }
}
