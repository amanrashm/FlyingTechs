package com.flyingtechs.studentManagement.model;

import com.flyingtechs.TestManagement.model.Test;
import com.flyingtechs.TestManagement.model.TestType;
import com.flyingtechs.userManagement.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

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

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, unique = true)
    @Size(max = 3, message = "Roll number can't exceed 3 characters")
    private String rollNumber;

    @Column(nullable = false)
    @Size(max = 10, message = "Batch can't exceed 10 characters")
    private String batch;

    @Column(nullable = false)
    @Size(max = 50, message = "Major can't exceed 50 characters")
    private String major;

    @Column(nullable = false)
    private int totalCredits;

    @Column(nullable = false)
    @Size(max = 50, message = "Academic advisor's name can't exceed 50 characters")
    private String academicAdvisor;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<HomeworkSubmission> homeworkSubmissions;

    @OneToMany(mappedBy = "student")
    private Set<Course> courses;

    @OneToMany(mappedBy = "student")
    private Set<AttendanceRecord> attendanceRecords;

    @OneToMany(mappedBy = "student")
    private Set<TestResult> testResults;

    @OneToMany(mappedBy = "student")
    private Set<TestType> testTypes;

    @OneToMany(mappedBy = "student")
    private Set<Test> tests;
}
