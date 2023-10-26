package com.flyingtechs.TestManagement.service.impl;

import com.flyingtechs.TestManagement.dao.TestTypeRepository;
import com.flyingtechs.TestManagement.model.TestType;
import com.flyingtechs.TestManagement.service.TestTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TestTypeServiceImpl implements TestTypeService {
    private final TestTypeRepository repository;

    public TestTypeServiceImpl(TestTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public TestType save(TestType entity) {
        return repository.save(entity);
    }

    @Override
    public List<TestType> save(List<TestType> entities) {
        return (List<TestType>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<TestType> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<TestType> findAll() {
        return (List<TestType>) repository.findAll();
    }

    @Override
    public Page<TestType> findAll(Pageable pageable) {
        Page<TestType> entityPage = repository.findAll(pageable);
        List<TestType> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public TestType update(TestType entity, Long id) {
        Optional<TestType> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}