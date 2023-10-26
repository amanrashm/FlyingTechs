package com.flyingtechs.teacherManagement.dto;

import com.flyingtechs.studentManagement.model.AttendanceRecord;

public class TeacherDTO extends AbstractDTO<Long> {
    private Long id;
    private AttendanceRecord attendanceRecord;

    public TeacherDTO() {
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
}