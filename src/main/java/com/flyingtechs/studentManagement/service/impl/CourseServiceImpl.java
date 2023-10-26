package com.flyingtechs.studentManagement.service.impl;

import com.flyingtechs.studentManagement.dao.CourseRepository;
import com.flyingtechs.studentManagement.model.Course;
import com.flyingtechs.studentManagement.service.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    private final CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Course save(Course entity) {
        return repository.save(entity);
    }

    @Override
    public List<Course> save(List<Course> entities) {
        return (List<Course>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Course> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Course> findAll() {
        return (List<Course>) repository.findAll();
    }

    @Override
    public Page<Course> findAll(Pageable pageable) {
        Page<Course> entityPage = repository.findAll(pageable);
        List<Course> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Course update(Course entity, Long id) {
        Optional<Course> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}