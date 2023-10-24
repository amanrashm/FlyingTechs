package com.flyingtechs.studentManagement.model;

import com.flyingtechs.userManagement.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Student_Table")
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Size(max = 3, message = "Roll number can't exceed 3 characters")
    private String rollNumber;

    @Size(max = 10, message = "Batch can't exceed 10 characters")
    private String batch;

    @Size(max = 50, message = "Major can't exceed 50 characters")
    private String major;

    private int totalCredits;

    @Size(max = 50, message = "Academic advisor's name can't exceed 50 characters")
    private String academicAdvisor;
/*
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<HomeworkSubmission> homeworkSubmissions;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;

    @OneToMany(mappedBy = "student")
    private Set<AttendanceRecord> attendanceRecords;

    @OneToMany(mappedBy = "student")
    private Set<TestResult> testResults;*/
}
