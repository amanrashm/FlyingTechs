package com.flyingtechs.studentManagement.service.impl;

import com.flyingtechs.studentManagement.dao.TestResultRepository;
import com.flyingtechs.studentManagement.model.TestResult;
import com.flyingtechs.studentManagement.service.TestResultService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TestResultServiceImpl implements TestResultService {
    private final TestResultRepository repository;

    public TestResultServiceImpl(TestResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public TestResult save(TestResult entity) {
        return repository.save(entity);
    }

    @Override
    public List<TestResult> save(List<TestResult> entities) {
        return (List<TestResult>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<TestResult> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<TestResult> findAll() {
        return (List<TestResult>) repository.findAll();
    }

    @Override
    public Page<TestResult> findAll(Pageable pageable) {
        Page<TestResult> entityPage = repository.findAll(pageable);
        List<TestResult> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public TestResult update(TestResult entity, Long id) {
        Optional<TestResult> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}