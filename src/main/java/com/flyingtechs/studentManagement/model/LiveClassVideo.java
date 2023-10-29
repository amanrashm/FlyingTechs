package com.flyingtechs.studentManagement.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "live_class_video")
public class LiveClassVideo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "live_class_video_gen")
    @SequenceGenerator(name = "live_class_video_gen", sequenceName = "live_class_video_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}