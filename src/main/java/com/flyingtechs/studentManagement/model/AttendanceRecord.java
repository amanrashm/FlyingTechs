package com.flyingtechs.studentManagement.model;

import com.flyingtechs.HrManagement.model.HR;
import com.flyingtechs.teacherManagement.model.Teacher;
import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "attendance_record")
public class AttendanceRecord {

    @Id
    @Column(name = "Attendance_Record_id", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HR_ID")
    private HR hr;

}