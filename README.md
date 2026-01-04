# Sassine-Awad-Module3-final-task-SchoolManagmentSystem04-01-2026
this is a pull request

School management system, the admin can be create (add) a course and student, update (edit) - search and delete, the student and course, also can view the list of student and course that  was adding 
أكيد، الـ README هو واجهة مشروعك، ومن المهم أن يعكس الجهد الاحترافي الذي بذلته في بناء النظام وتقسيم الطبقات (Layered Architecture).

إليك ملف README.md كامل ومنظم باللغتين (الإنجليزية مع وصف بالعربية) ليكون جاهزاً للرفع على GitHub أو تقديمه كتوثيق للمشروع:

🎓 Student Management System (SMS) - Spring Boot
نظام إدارة طلاب متكامل مبني باستخدام تقنيات Spring Boot و Thymeleaf. يتيح النظام للمسؤول (Admin) إدارة الكورسات، تسجيل الطلاب، وربطهم بالكورسات المختارة مع متابعة المدفوعات.

🚀 المميزات (Features)
Course Management: إضافة، تعديل، حذف، والبحث عن الكورسات.

Student Registration: تسجيل بيانات الطلاب المفصلة (الاسم، السجل، العنوان، الهاتف).

Course Enrollment: ربط الطلاب بالكورسات المتاحة (Relationship Many-to-One).

Search Functionality: ميزة البحث الذكي بالاسم أو رقم الهاتف.

Responsive UI: واجهة مستخدم بيضاء ونظيفة باستخدام Bootstrap 5.

🛠 التقنيات المستخدمة (Tech Stack)
Backend: Java 17+, Spring Boot 3.x.

Database: MySQL.

ORM: Spring Data JPA (Hibernate).

View Engine: Thymeleaf.

Styling: Bootstrap 5 & Google Fonts.

Tools: Lombok, ModelMapper.

📂 هيكلية المشروع (Project Structure)
يتبع المشروع نمط Layered Architecture لضمان نظافة الكود:

model: يحتوي على الـ Entities (Students, Courses).

repository: للتعامل مع قاعدة البيانات (JPA Repositories).

service: يحتوي على المنطق البرمجي (Business Logic).

dto: لنقل البيانات بين الطبقات (Data Transfer Objects).

controller: للتحكم في المسارات والروابط (Routes).

templates: ملفات الـ HTML (Thymeleaf).

⚙️ إعدادات التشغيل (Setup)
1. قاعدة البيانات (Database)
قم بإنشاء قاعدة بيانات باسم student_mgmt_db في MySQL:

SQL

CREATE DATABASE student_mgmt_db;
2. إعدادات التطبيق (application.properties)
تأكد من تعديل بيانات الدخول في ملف src/main/resources/application.properties:

Properties

spring.datasource.url=jdbc:mysql://localhost:3306/student_mgmt_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
3. التشغيل
يمكنك تشغيل المشروع باستخدام IntelliJ IDEA أو عبر الأمر:

Bash

mvn spring-boot:run
🖥 روابط النظام (Quick Links)
Dashboard: http://localhost:8080/student/list

Courses List: http://localhost:8080/course/list

Add New Student: http://localhost:8080/student/new
🛠 التحديثات القادمة (Future Improvements)
لجعل النظام أكثر قوة وجاهزية للاستخدام التجاري، سيتم العمل على الميزات التالية:

نظام الحماية (Spring Security): إضافة صفحة تسجيل دخول (Login) وتحديد صلاحيات للأدوار (Roles) مثل الـ Admin والموظف.

طباعة التقارير (Reporting System): إمكانية استخراج بيانات الطلاب أو الكورسات على شكل ملفات PDF أو Excel.

لوحة تحكم إحصائية (Dashboard Statistics): عرض رسوم بيانية توضح عدد الطلاب المسجلين في كل كورس وإجمالي المبالغ المدفوعة.

نظام الإشعارات (Notifications): إرسال رسائل بريد إلكتروني تلقائية للطلاب عند التسجيل أو عند تحديث بياناتهم.

التحقق المتقدم (Advanced Validation): إضافة قيود أكثر صرامة على المدخلات (مثل التأكد من صيغة رقم الهاتف أو عدم تكرار رقم الهوية).

نصيحة لترتيب ملفاتك:
بما أنك أتممت الآن نظام الكورسات ونظام الطلاب، تأكد من أنك قمت بحفظ جميع الملفات وعمل Build للمشروع للتأكد من عدم وجود أي "أخطاء حمراء" في الـ IDE.

📸 صور من النظام (Screenshots)
يمكنك إضافة صورك هنا لاحقاً.
