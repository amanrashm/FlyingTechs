package com.flyingtechs.studentManagement.service;

import com.flyingtechs.studentManagement.model.Student;

public interface StudentService extends GenericService<Student, Long> {
    Student update(Student student, Long id);
}