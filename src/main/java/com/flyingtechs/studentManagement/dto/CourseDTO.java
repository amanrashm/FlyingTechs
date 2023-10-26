package com.flyingtechs.studentManagement.dto;

import com.flyingtechs.studentManagement.model.Course;
import com.flyingtechs.studentManagement.model.Student;

public class CourseDTO extends AbstractDTO<Long> {
    private Long id;
    private Student student;

    public CourseDTO(Course course) {
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

    public static Object fromEntity(Course course) {
        return null;
    }

    public Course toEntity() {
        return null;
    }
}