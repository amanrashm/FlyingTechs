package com.flyingtechs.TestManagement.dto;

import com.flyingtechs.TestManagement.model.TestType;
import com.flyingtechs.studentManagement.model.Student;

public class TestDTO extends AbstractDTO<Long> {
    private Long id;
    private String testName;
    private String testDescription;
    private TestType testType;
    private int totalMarks;
    private Date testDate;
    private Student student;

    public TestDTO() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestName() {
        return this.testName;
    }

    public void setTestDescription(String testDescription) {
        this.testDescription = testDescription;
    }

    public String getTestDescription() {
        return this.testDescription;
    }

    public void setTestType(TestType testType) {
        this.testType = testType;
    }

    public TestType getTestType() {
        return this.testType;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public int getTotalMarks() {
        return this.totalMarks;
    }

    public void setTestDate(java.util.Date testDate) {
        this.testDate = testDate;
    }

    public java.util.Date getTestDate() {
        return this.testDate;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return this.student;
    }
}