package com.flyingtechs.HrManagement.service.impl;

import com.flyingtechs.HrManagement.dao.HRRepository;
import com.flyingtechs.HrManagement.model.HR;
import com.flyingtechs.HrManagement.service.HRService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HRServiceImpl implements HRService {
    private final HRRepository repository;

    public HRServiceImpl(HRRepository repository) {
        this.repository = repository;
    }

    @Override
    public HR save(HR entity) {
        return repository.save(entity);
    }

    @Override
    public List<HR> save(List<HR> entities) {
        return (List<HR>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<HR> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<HR> findAll() {
        return (List<HR>) repository.findAll();
    }

    @Override
    public Page<HR> findAll(Pageable pageable) {
        Page<HR> entityPage = repository.findAll(pageable);
        List<HR> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public HR update(HR entity, Long id) {
        Optional<HR> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}