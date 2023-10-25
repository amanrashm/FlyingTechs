package com.flyingtechs.studentManagement.dto;

import com.flyingtechs.userManagement.model.User;

public class StudentDTO extends AbstractDTO<Long> {
    private Long id;
    private User user;
    private String rollNumber;
    private String batch;
    private String major;
    private int totalCredits;
    private String academicAdvisor;

    public StudentDTO() {
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
}