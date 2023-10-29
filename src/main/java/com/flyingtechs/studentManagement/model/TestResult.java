package com.flyingtechs.studentManagement.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "test_result")
public class TestResult {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String testTitle;

    private double score;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}