package com.flyingtechs.studentManagement.service.impl;

import com.flyingtechs.studentManagement.dao.HomeworkSubmissionRepository;
import com.flyingtechs.studentManagement.model.HomeworkSubmission;
import com.flyingtechs.studentManagement.service.HomeworkSubmissionService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HomeworkSubmissionServiceImpl implements HomeworkSubmissionService {
    private final HomeworkSubmissionRepository repository;

    public HomeworkSubmissionServiceImpl(HomeworkSubmissionRepository repository) {
        this.repository = repository;
    }

    @Override
    public HomeworkSubmission save(HomeworkSubmission entity) {
        return repository.save(entity);
    }

    @Override
    public List<HomeworkSubmission> save(List<HomeworkSubmission> entities) {
        return (List<HomeworkSubmission>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<HomeworkSubmission> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<HomeworkSubmission> findAll() {
        return (List<HomeworkSubmission>) repository.findAll();
    }

    @Override
    public Page<HomeworkSubmission> findAll(Pageable pageable) {
        Page<HomeworkSubmission> entityPage = repository.findAll(pageable);
        List<HomeworkSubmission> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public HomeworkSubmission update(HomeworkSubmission entity, Long id) {
        Optional<HomeworkSubmission> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}