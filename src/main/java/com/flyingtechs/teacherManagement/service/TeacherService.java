package com.flyingtechs.teacherManagement.service;

import com.flyingtechs.teacherManagement.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    Teacher save(Teacher entity);

    List<Teacher> save(List<Teacher> entities);

    void deleteById(Long id);

    Optional<Teacher> findById(Long id);

    List<Teacher> findAll();

    Page<Teacher> findAll(Pageable pageable);

    Teacher update(Teacher entity, Long id);
}
