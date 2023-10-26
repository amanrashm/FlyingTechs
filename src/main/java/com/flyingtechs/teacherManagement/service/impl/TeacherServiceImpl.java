package com.flyingtechs.teacherManagement.service.impl;

import com.flyingtechs.teacherManagement.dao.TeacherRepository;
import com.flyingtechs.teacherManagement.model.Teacher;
import com.flyingtechs.teacherManagement.service.TeacherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository repository;

    public TeacherServiceImpl(TeacherRepository repository) {
        this.repository = repository;
    }

    @Override
    public Teacher save(Teacher entity) {
        return repository.save(entity);
    }

    @Override
    public List<Teacher> save(List<Teacher> entities) {
        return (List<Teacher>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Teacher> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Teacher> findAll() {
        return (List<Teacher>) repository.findAll();
    }

    @Override
    public Page<Teacher> findAll(Pageable pageable) {
        Page<Teacher> entityPage = repository.findAll(pageable);
        List<Teacher> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Teacher update(Teacher entity, Long id) {
        Optional<Teacher> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}