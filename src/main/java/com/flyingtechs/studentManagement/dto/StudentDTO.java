package com.flyingtechs.studentManagement.dto;

import com.flyingtechs.TestManagement.model.Test1;
import com.flyingtechs.TestManagement.model.TestType;
import com.flyingtechs.studentManagement.model.*;
import com.flyingtechs.userManagement.model.User;

import java.util.Set;

public class StudentDTO extends AbstractDTO<Long> {
    private Long id;
    private User user;
    private String rollNumber;
    private String batch;
    private String major;
    private int totalCredits;
    private String academicAdvisor;
    private Set<HomeworkSubmission> homeworkSubmissions;
    private Set<Course> courses;
    private Set<AttendanceRecord> attendanceRecords;
    private Set<TestResult> testResults;
    private Set<TestType> testTypes;
    private Set<Test1> test1s;

    public StudentDTO(Student student) {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getRollNumber() {
        return this.rollNumber;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getBatch() {
        return this.batch;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajor() {
        return this.major;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public int getTotalCredits() {
        return this.totalCredits;
    }

    public void setAcademicAdvisor(String academicAdvisor) {
        this.academicAdvisor = academicAdvisor;
    }

    public String getAcademicAdvisor() {
        return this.academicAdvisor;
    }

    public void setHomeworkSubmissions(java.util.Set<com.flyingtechs.studentManagement.model.HomeworkSubmission> homeworkSubmissions) {
        this.homeworkSubmissions = homeworkSubmissions;
    }

    public Set<HomeworkSubmission> getHomeworkSubmissions() {
        return this.homeworkSubmissions;
    }

    public void setCourses(java.util.Set<com.flyingtechs.studentManagement.model.Course> courses) {
        this.courses = courses;
    }

    public java.util.Set<com.flyingtechs.studentManagement.model.Course> getCourses() {
        return this.courses;
    }

    public void setAttendanceRecords(java.util.Set<com.flyingtechs.studentManagement.model.AttendanceRecord> attendanceRecords) {
        this.attendanceRecords = attendanceRecords;
    }

    public Set<AttendanceRecord> getAttendanceRecords() {
        return this.attendanceRecords;
    }

    public void setTestResults(java.util.Set<com.flyingtechs.studentManagement.model.TestResult> testResults) {
        this.testResults = testResults;
    }

    public Set<TestResult> getTestResults() {
        return this.testResults;
    }

    public void setTestTypes(java.util.Set<com.flyingtechs.TestManagement.model.TestType> testTypes) {
        this.testTypes = testTypes;
    }

    public java.util.Set<com.flyingtechs.TestManagement.model.TestType> getTestTypes() {
        return this.testTypes;
    }

    public void setTests(java.util.Set<Test1> test1s) {
        this.test1s = test1s;
    }

    public Set<Test1> getTests() {
        return this.test1s;
    }

    public static Object fromEntity(Student student) {
        return null;
    }

    public Student toEntity() {
        return null;
    }
}