package com.flyingtechs.TestManagement.dto;

import com.flyingtechs.TestManagement.model.TestType;
import com.flyingtechs.studentManagement.model.Student;

public class TestTypeDTO extends AbstractDTO<Long> {
    private Long id;
    private Student student;

    public TestTypeDTO(TestType testType) {
    }

    public static TestTypeDTO fromEntity(TestType save) {
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

    public TestType toEntity() {
        return null;
    }
}