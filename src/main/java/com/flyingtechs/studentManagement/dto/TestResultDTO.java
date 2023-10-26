package com.flyingtechs.studentManagement.dto;

import com.flyingtechs.studentManagement.model.Student;
import com.flyingtechs.studentManagement.model.TestResult;

public class TestResultDTO extends AbstractDTO<Long> {
    private Long id;
    private Student student;

    public TestResultDTO(TestResult testResult) {
    }

    public static TestResultDTO fromEntity(Object update) {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return this.student;
    }

    public TestResult toEntity() {
        return null;
    }
}