package com.bootcamp.sms.controller;

import com.bootcamp.sms.dto.StudentDTO;
import com.bootcamp.sms.service.CourseService;
import com.bootcamp.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student") // هذا يعني أن كل الروابط تبدأ بـ /student
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    /**
     * عرض قائمة الطلاب مع ميزة البحث
     * الرابط: localhost:8080/student/list
     */
    @GetMapping("/list")
    public String listStudents(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<StudentDTO> students;

        // إذا كان هناك نص في مربع البحث، نقوم بالفلترة، وإلا نجلب الكل
        if (keyword != null && !keyword.isEmpty()) {
            students = studentService.searchStudents(keyword);
        } else {
            students = studentService.getAllStudents();
        }

        model.addAttribute("students", students);
        model.addAttribute("keyword", keyword); // لإبقاء نص البحث داخل المربع في الصفحة
        return "students"; // يفتح ملف students.html
    }

    /**
     * عرض صفحة إضافة طالب جديد
     * الرابط: localhost:8080/student/new
     */
    @GetMapping("/new")
    public String showAddForm(Model model) {
        // نرسل كائن طالب فارغ للفورم
        model.addAttribute("student", new StudentDTO());

        // نرسل قائمة الكورسات لملء القائمة المنسدلة (Dropdown)
        model.addAttribute("courses", courseService.getAllCourses());

        return "add-student"; // يفتح ملف add-student.html
    }

    /**
     * عرض صفحة تعديل طالب موجود
     * الرابط: localhost:8080/student/edit/{id}
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        // جلب بيانات الطالب المحددة بالـ ID
        StudentDTO studentDTO = studentService.getStudentById(id);

        model.addAttribute("student", studentDTO);
        model.addAttribute("courses", courseService.getAllCourses());

        return "edit-student"; // يفتح ملف edit-student.html
    }

    /**
     * ميثود الحفظ (للإضافة والتعديل معاً)
     */
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") StudentDTO studentDTO) {
        // الـ Service سيتولى عملية الربط بالكورس والحفظ في قاعدة البيانات
        studentService.saveStudent(studentDTO);

        // بعد الحفظ نعود لجدول الطلاب
        return "redirect:/student/list";
    }

    /**
     * حذف طالب
     * الرابط: localhost:8080/student/delete/{id}
     */
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/student/list";
    }
    @GetMapping("/dashboard")
    public String home() {
        return "redirect:/student/list"; // مؤقتاً يحولك لصفحة الطلاب بدلاً من الخطأ
    }

}