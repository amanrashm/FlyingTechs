package com.flyingtechs.studentManagement.service;

import com.flyingtechs.studentManagement.model.Course;

public interface CourseService extends GenericService<Course, Long> {
    Course update(Course course, Long id);
}