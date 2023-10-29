package com.flyingtechs.studentManagement.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String courseName;

    @Lob
    private String courseDescription;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}