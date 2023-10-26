package com.flyingtechs.TestManagement.service.impl;

import com.flyingtechs.TestManagement.dao.TestRepository;
import com.flyingtechs.TestManagement.model.Test1;
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
    public Test1 save(Test1 entity) {
        return repository.save(entity);
    }

    @Override
    public List<Test1> save(List<Test1> entities) {
        return (List<Test1>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Test1> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Test1> findAll() {
        return (List<Test1>) repository.findAll();
    }

    @Override
    public Page<Test1> findAll(Pageable pageable) {
        Page<Test1> entityPage = repository.findAll(pageable);
        List<Test1> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Test1 update(Test1 entity, Long id) {
        Optional<Test1> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}