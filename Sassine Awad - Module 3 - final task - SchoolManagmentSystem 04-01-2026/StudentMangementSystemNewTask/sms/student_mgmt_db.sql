USE student_mgmt_db;

CREATE TABLE IF NOT EXISTS courses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(255) NOT NULL,
    course_code VARCHAR(255) NOT NULL UNIQUE,
    duration VARCHAR(255),
    active TINYINT(1) NOT NULL DEFAULT 1, -- Matches boolean active = true
    fee DECIMAL(12, 2) NOT NULL,
    description VARCHAR(1000),
    created_at DATETIME NOT NULL
);
select * from student_mgmt_db.courses;
USE student_mgmt_db;
UPDATE courses SET active = 1;
COMMIT;
select * from student_mgmt_db.courses;
UPDATE `student_mgmt_db`.`courses` SET `active` = 1 WHERE `id` = 1;
ALTER TABLE courses MODIFY COLUMN active TINYINT(1) DEFAULT 1;
UPDATE courses SET active = 1 WHERE id = 1;
USE student_mgmt_db;

CREATE TABLE IF NOT EXISTS students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    father_name VARCHAR(255),
    last_name VARCHAR(255) NOT NULL,
    date_of_birth DATE,
    place_of_birth VARCHAR(255),
    identity_number VARCHAR(100), -- رقم السجل حسب الهوية
    district VARCHAR(100),       -- القضاء
    governorate VARCHAR(100),    -- المحافظة
    town VARCHAR(100),           -- البلدة
    
    -- مكان السكن بالتفصيل
    building_name VARCHAR(255),
    building_number VARCHAR(50),
    building_owner VARCHAR(255),
    floor VARCHAR(50),
    house_owner VARCHAR(255),
    detailed_address TEXT,
    
    phone_number VARCHAR(50),
    amount_paid DOUBLE,
    
    -- الربط مع جدول الكورسات
    course_id BIGINT,
    CONSTRAINT fk_student_course FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE SET NULL
);
select * from student_mgmt_db.students;