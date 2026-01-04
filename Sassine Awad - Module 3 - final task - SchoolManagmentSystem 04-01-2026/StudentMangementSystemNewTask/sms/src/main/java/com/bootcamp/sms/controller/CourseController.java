package com.bootcamp.sms.controller;

import com.bootcamp.sms.dto.CourseDTO;
import com.bootcamp.sms.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    // Constructor Injection
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping("/new")
    public String showCreateCourse(Model model){
        model.addAttribute("courseDTO", new CourseDTO());
        return "add-course";
    }

    @GetMapping("/list")
    public String listCourses(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<CourseDTO> courses;

        // المنطق المدمج:
        // إذا كان هناك نص في مربع البحث، نستخدم ميثود البحث
        if (keyword != null && !keyword.isEmpty()) {
            courses = courseService.searchCourses(keyword);
        } else {
            // إذا لم يكن هناك بحث (الحالة الأساسية السابقة)، نطلب كل الكورسات
            courses = courseService.getAllCourses();
        }

        // إرسال البيانات للـ HTML
        model.addAttribute("courses", courses);

        // إرسال الكلمة المفتاحية لتبقى ظاهرة في مربع البحث بعد الضغط على Search
        model.addAttribute("keyword", keyword);

        return "courses";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "redirect:/course/list";
    }

    @PostMapping
    public String createCourse(@Valid @ModelAttribute("courseDTO") CourseDTO courseDTO,
                               BindingResult bindingResult,
                               Model model,
                               RedirectAttributes redirectAttributes){

        // 1. التحقق من أخطاء الـ Validation (مثل الحقول المطلوبة)
        if(bindingResult.hasErrors()){
            return "add-course";
        }

        // 2. التحقق من عدم تكرار كود الكورس
        if(courseService.existsByCourseCode(courseDTO.getCourseCode())){
            bindingResult.rejectValue("courseCode", "error.courseDTO", "Course code already exists");
            return "add-course";
        }

        // 3. حفظ الكورس
        courseService.createCourse(courseDTO);

        // التعديل: استخدام addFlashAttribute لضمان انتقال الرسالة عبر الـ Redirect
        redirectAttributes.addFlashAttribute("message", "Course is created successfully");

        return "redirect:/course/list";
    }
    // 1. فتح صفحة التعديل ببيانات الكورس المختار
    @GetMapping("/edit/{id}")
    public String editCourseForm(@PathVariable Long id, Model model) {
        model.addAttribute("course", courseService.getCourseById(id));
        return "edit-course"; // سنقوم بإنشاء هذا الملف HTML الآن
    }

    // 2. استقبال البيانات المعدلة وحفظها
    @PostMapping("/update/{id}")
    public String updateCourse(@PathVariable Long id, @ModelAttribute("course") CourseDTO courseDTO) {
        // سنستخدم نفس ميثود الـ create لأن save في JPA تقوم بالتحديث إذا كان الـ ID موجوداً
        courseService.createCourse(courseDTO);
        return "redirect:/course/list";
    }

}