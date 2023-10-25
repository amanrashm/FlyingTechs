package com.flyingtechs.studentManagement.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "attendance_record")
public class AttendanceRecord {
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}