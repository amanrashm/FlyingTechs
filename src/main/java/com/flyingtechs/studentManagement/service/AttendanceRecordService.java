package com.flyingtechs.studentManagement.service;

import com.flyingtechs.studentManagement.model.AttendanceRecord;

public interface AttendanceRecordService extends GenericService<AttendanceRecord, Long> {
    AttendanceRecord update(AttendanceRecord attendanceRecord, Long id);
}