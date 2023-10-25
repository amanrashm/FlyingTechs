package com.flyingtechs.studentManagement.repository;

import com.flyingtechs.studentManagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepository extends JpaRepository<Student, Long> {

}