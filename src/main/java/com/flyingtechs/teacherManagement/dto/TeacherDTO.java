package com.flyingtechs.teacherManagement.dto;

import com.flyingtechs.studentManagement.model.AttendanceRecord;
import com.flyingtechs.teacherManagement.model.Teacher;

public class TeacherDTO extends AbstractDTO<Long> {
    private Long id;
    private AttendanceRecord attendanceRecord;

    public TeacherDTO(Teacher teacher) {
    }

    public static TeacherDTO fromEntity(Teacher save) {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setAttendanceRecord(AttendanceRecord attendanceRecord) {
        this.attendanceRecord = attendanceRecord;
    }

    public AttendanceRecord getAttendanceRecord() {
        return this.attendanceRecord;
    }

    public Teacher toEntity() {
        return null;
    }
}