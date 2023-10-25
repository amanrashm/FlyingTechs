package com.flyingtechs.TestManagement.service.impl;

import com.flyingtechs.TestManagement.dao.TestRepository;
import com.flyingtechs.TestManagement.model.Test;
import com.flyingtechs.TestManagement.service.TestService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TestServiceImpl implements TestService {
    private final TestRepository repository;

    public TestServiceImpl(TestRepository repository) {
        this.repository = repository;
    }

    @Override
    public Test save(Test entity) {
        return repository.save(entity);
    }

    @Override
    public List<Test> save(List<Test> entities) {
        return (List<Test>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Test> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Test> findAll() {
        return (List<Test>) repository.findAll();
    }

    @Override
    public Page<Test> findAll(Pageable pageable) {
        Page<Test> entityPage = repository.findAll(pageable);
        List<Test> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Test update(Test entity, Long id) {
        Optional<Test> optional = findById(id) );
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}