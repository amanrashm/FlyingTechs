package com.flyingtechs.studentManagement.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "homework_submission")
public class HomeworkSubmission {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String homeworkTitle;

    @Lob
    private byte[] homeworkData;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}