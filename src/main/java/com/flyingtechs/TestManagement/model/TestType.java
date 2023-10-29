package com.flyingtechs.TestManagement.model;

import com.flyingtechs.studentManagement.model.Student;
import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "test_type")
public class TestType {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String typeName;

    private int totalTests;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}