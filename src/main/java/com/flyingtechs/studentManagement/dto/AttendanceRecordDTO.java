package com.flyingtechs.studentManagement.dto;

import com.flyingtechs.studentManagement.model.AttendanceRecord;
import com.flyingtechs.studentManagement.model.Student;
import com.flyingtechs.teacherManagement.model.Teacher;

public class AttendanceRecordDTO extends AbstractDTO<Long> {
    private Long id;
    private Student student;
    private Teacher teacher;

    public AttendanceRecordDTO(AttendanceRecord record) {
    }

    public static AttendanceRecordDTO fromEntity(AttendanceRecord save) {
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

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public AttendanceRecord toEntity() {
        return null;
    }
}