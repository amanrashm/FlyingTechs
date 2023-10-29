package com.flyingtechs.studentManagement.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "chat_message")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chat_message_gen")
    @SequenceGenerator(name = "chat_message_gen", sequenceName = "chat_message_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_student_id")
    private Student sender;

    @ManyToOne
    @JoinColumn(name = "receiver_student_id")
    private Student receiver;

    private String message;

    private LocalDateTime timestamp;
}