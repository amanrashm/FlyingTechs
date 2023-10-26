package com.flyingtechs.studentManagement.dto;

import com.flyingtechs.studentManagement.model.HomeworkSubmission;
import com.flyingtechs.studentManagement.model.Student;

public class HomeworkSubmissionDTO extends AbstractDTO<Long> {
    private Long id;
    private Student student;

    public HomeworkSubmissionDTO(HomeworkSubmission submission) {
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

    public static Object fromEntity(HomeworkSubmission homeworkSubmission) {
        return null;
    }

    public HomeworkSubmission toEntity() {
        return null;
    }
}