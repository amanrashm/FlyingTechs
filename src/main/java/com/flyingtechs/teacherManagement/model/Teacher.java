package com.flyingtechs.teacherManagement.model;

import com.flyingtechs.TestManagement.model.Test1;
import com.flyingtechs.studentManagement.model.AttendanceRecord;
import com.flyingtechs.studentManagement.model.Course;
import com.flyingtechs.studentManagement.model.HomeworkSubmission;
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

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "Attendance_Record_id", nullable = false, unique = true)
    private AttendanceRecord attendanceRecord;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "homework_submission_id", nullable = false)
    private HomeworkSubmission homeworkSubmission;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "test_1_id", nullable = false)
    private Test1 test1;

}
