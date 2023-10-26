package com.flyingtechs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.flyingtechs.userManagement.service")
public class FlyingTechsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlyingTechsApplication.class, args);
    }

}
/*
*
* FlyingTechsERP (Root Project)
│
├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── flyingtechs
│       │           └── erp
│       │               ├── FlyingTechsErpApplication.java (Main Application Class)
│       │               │
│       │               ├── common
│       │               │   ├── config
│       │               │   │   ├── SecurityConfig.java (Security Configuration)
│       │               │   │   ├── AuditTrailInterceptor.java (Audit Trail Interceptor)
│       │               │   │
│       │               │   ├── util
│       │               │   │   ├── ErrorDTO.java (Error Data Transfer Object)
│       │               │   │
│       │               │   ├── validation
│       │               │   │   ├── ValidationService.java (Data Validation Service)
│       │               │   │
│       │               │   ├── exception
│       │               │   │   ├── CustomException.java (Custom Exception)
│       │               │   │   ├── GlobalExceptionHandler.java (Exception Handler)
│       │               │   │
│       │               │   ├── ...
│       │               │
│       │               ├── usermanagement
│       │               │   ├── model
│       │               │   │   ├── User.java (User Entity)
│       │               │   │
│       │               │   ├── repository
│       │               │   │   ├── UserRepository.java (User Repository)
│       │               │   │
│       │               │   ├── service
│       │               │   │   ├── UserService.java (User Service)
│       │               │   │
│       │               │   ├── controller
│       │               │   │   ├── UserController.java (User API Controller)
│       │               │   │   ├── UserProfileController.java (User Profile Controller)
│       │               │   │
│       │               │   │
│       │               │
│       │               ├── authentication
│       │               │   ├── JwtTokenProvider.java (JWT Token Provider)
│       │               │   │
│       │               ├── studentmanagement
│       │               │   ├── model
│       │               │   │   ├── Student.java (Student Entity)
│       │               │   │
│       │               │   ├── repository
│       │               │   │   ├── StudentRepository.java (Student Repository)
│       │               │   │
│       │               │   ├── service
│       │               │   │   ├── StudentService.java (Student Service)
│       │               │   │
│       │               │   ├── controller
│       │               │   │   ├── StudentController.java (Student API Controller)
│       │               │   │
│       │               │   │
│       │               │
│       │               ├── teachermanagement
│       │               │   ├── model
│       │               │   │   ├── Teacher.java (Teacher Entity)
│       │               │   │
│       │               │   ├── repository
│       │               │   │   ├── TeacherRepository.java (Teacher Repository)
│       │               │   │
│       │               │   ├── service
│       │               │   │   ├── TeacherService.java (Teacher Service)
│       │               │   │
│       │               │   ├── controller
│       │               │   │   ├── TeacherController.java (Teacher API Controller)
│       │               │   │
│       │               │   │
│       │               │
│       │               ├── hrmanagement
│       │               │   ├── model
│       │               │   │   ├── HR.java (HR Entity)
│       │               │   │
│       │               │   ├── repository
│       │               │   │   ├── HRRepository.java (HR Repository)
│       │               │   │
│       │               │   ├── service
│       │               │   │   ├── HRService.java (HR Service)
│       │               │   │
│       │               │   ├── controller
│       │               │   │   ├── HRController.java (HR API Controller)
│       │               │   │
│       │               │   │
│       │               │
│       │               ├── testmanagement
│       │               │   ├── model
│       │               │   │   ├── Test.java (Test Entity)
│       │               │   │
│       │               │   ├── repository
│       │               │   │   ├── TestRepository.java (Test Repository)
│       │               │   │
│       │               │   ├── service
│       │               │   │   ├── TestService.java (Test Service)
│       │               │   │
│       │               │   ├── controller
│       │               │   │   ├── TestController.java (Test API Controller)
│       │               │   │
│       │               │   │
│       │               │
│       │               ├── homework
│       │               │   ├── model
│       │               │   │   ├── Homework.java (Homework Entity)
│       │               │   │
│       │               │   ├── repository
│       │               │   │   ├── HomeworkRepository.java (Homework Repository)
│       │               │   │
│       │               │   ├── service
│       │               │   │   ├── HomeworkService.java (Homework Service)
│       │               │   │
│       │               │   ├── controller
│       │               │   │   ├── HomeworkController.java (Homework API Controller)
│       │               │   │
│       │               │
│       │               ├── documentmanagement
│       │               │   ├── model
│       │               │   │   ├── Document.java (Document Entity)
│       │               │   │
│       │               │   ├── repository
│       │               │   │   ├── DocumentRepository.java (Document Repository)
│       │               │   │
│       │               │   ├── service
│       │               │   │   ├── DocumentService.java (Document Service)
│       │               │   │
│       │               │   ├── controller
│       │               │   │   ├── DocumentController.java (Document API Controller)
│       │               │   │
│       │               │
│       │               ├── chat
│       │               │   ├── controller
│       │               │   │   ├── ChatController.java (Chat API Controller)
│       │               │   │
│       │               │
│       │               ├── messaging
│       │               │   ├── service
│       │               │   │   ├── MessagingService.java (Messaging Service)
│       │               │   │
│       │               │
│       │               ├── analytics
│       │               │   ├── model
│       │               │   │   ├── AnalyticsData.java (Analytics Data Entity)
│       │               │   │
│       │               │   ├── repository
│       │               │   │   ├── AnalyticsDataRepository.java (Analytics Data Repository)
│       │               │   │
│       │               │   ├── service
│       │               │   │   ├── AnalyticsService.java (Analytics Service)
│       │               │   │
│       │               │   ├── controller
│       │               │   │   ├── AnalyticsController.java (Analytics API Controller)
│       │               │   │
│       │               │
│       │               ├── notification
│       │               │   ├── service
│       │               │   │   ├── NotificationService.java (Notification Service)
│       │               │   │
│       │               │
│       │               ├── studentmanagement
│       │               │   ├── validation
│       │               │   │   ├── StudentValidationService.java (Student Validation Service)
│       │               │   │
│       │               │
│       │               ├── idcard
│       │               │   ├── service
│       │               │   │   ├── IDCardService.java (ID Card Service)
│       │               │   │
│       │               │
│       │               ├── attendance
│       │               │   ├── service
│       │               │   │   ├── AttendanceService.java (Attendance Service)
│       │               │   │
│       │               │
│       │               ├── interview
│       │               │   ├── model
│       │               │   │   ├── Interview.java (Interview Entity)
│       │               │   │
│       │               │   ├── repository
│       │               │   │   ├── InterviewRepository.java (Interview Repository)
│       │               │   │
│       │               │   ├── service
│       │               │   │   ├── InterviewService.java (Interview Service)
│       │               │   │
│       │               │   ├── controller
│       │               │   │   ├── InterviewController.java (Interview API Controller)
│       │               │   │
│       │               │
│       │               ├── payment
│       │               │   ├── service
│       │               │   │   ├── PaymentService.java (Payment Service)
│       │               │   │
│       │               │
│       └── resources
│           ├── application.properties (Application Configuration)
│           ├── log4j2.xml (Logging Configuration)
│           └── static
│               ├── index.html (Main Entry Point)
│               ├── css
│               │   ├── styles.css (Global Styles)
│               │
│               ├── js
│               │   ├── main.js (Main JavaScript Entry Point)
│               │   ├── exam.js (Exam-Related JavaScript)
│               │   ├── chat.js (Real-time Chat JavaScript)
│               │   ├── messaging.js (Messaging JavaScript)
│               │   ├── analytics.js (Analytics JavaScript)
│               │   ├── notification.js (Notification JavaScript)
│               │   ├── ...
│               │
│               ├── images (Image Assets)
│               │
│               ├── templates (HTML Templates)
│               │   ├── user
│               │   │   ├── login.html (User Login Page)
│               │   │   ├── registration.html (User Registration Page)
│               │   │   ├── ...
│               │   │
│               │   ├── student
│               │   │   ├── student-dashboard.html (Student Dashboard)
│               │   │   ├── student-exam.html (Student Exam Page)
│               │   │   ├── ...
│               │   │
│               │   ├── teacher
│               │   │   ├── teacher-dashboard.html (Teacher Dashboard)
│               │   │   ├── teacher-exam.html (Teacher Exam Page)
│               │   │   ├── ...
│               │   │
│               │   ├── admin
│               │   │   ├── admin-dashboard.html (Admin Dashboard)
│               │   │   ├── ...
│               │   │
│               │   ├── idcard
│               │   │   ├── idcard-generation.html (ID Card Generation Page)
│               │   │   ├── ...
│               │
│               │
│           └── templates (Thymeleaf Templates - if used)
│               ├── ...
│
├── db
│   ├── migrations (Database Schema Migrations)
│   │   ├── V1__Create_Users_Table.sql
│   │   ├── V2__Create_Students_Table.sql
│   │   ├── V3__Create_Teachers_Table.sql
│   │   ├── V4__Create_HRs_Table.sql
│   │   ├── V5__Create_Tests_Table.sql
│   │   ├── V6__Create_Homework_Table.sql
│   │   ├── V7__Create_Documents_Table.sql
│   │   ├── V8__Create_Interviews_Table.sql
│   │   ├── V9__Create_Payments_Table.sql
│   │   ├── ...
│
│   ├── schema.sql (Initial Database Schema)
*/