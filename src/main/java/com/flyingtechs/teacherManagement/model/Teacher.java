package com.flyingtechs.teacherManagement.model;

import com.flyingtechs.studentManagement.model.AttendanceRecord;
import com.flyingtechs.studentManagement.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Teacher {


    @Id
    @Column(name = "teacher_id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Attendance_Record_id")
    private AttendanceRecord attendanceRecord;



}
