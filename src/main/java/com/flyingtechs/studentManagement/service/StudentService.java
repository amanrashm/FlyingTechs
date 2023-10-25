package com.flyingtechs.studentManagement.service;

import com.flyingtechs.studentManagement.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student save(Student entity);

    List<Student> save(List<Student> entities);

    void deleteById(Long id);

    Optional<Student> findById(Long id);

    List<Student> findAll();

    Page<Student> findAll(Pageable pageable);

    Student update(Student entity, Long id);
}
