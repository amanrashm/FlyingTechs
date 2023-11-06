package com.flyingtechs.studentManagement.model;

import com.flyingtechs.video.LiveVideoClass;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_gen")
    @SequenceGenerator(name = "note_gen", sequenceName = "note_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private String title;

    @Lob
    private byte[] pdfData;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "live_video_class_id")
    private LiveVideoClass liveVideoClass;

}