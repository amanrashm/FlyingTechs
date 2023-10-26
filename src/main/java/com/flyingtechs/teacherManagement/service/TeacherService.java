package com.flyingtechs.teacherManagement.service;

import com.flyingtechs.teacherManagement.model.Teacher;

public interface TeacherService extends GenericService<Teacher, Long> {
    Teacher update(Teacher entity, Long id);
}