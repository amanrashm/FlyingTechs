package com.flyingtechs.studentManagement.service.impl;

import com.flyingtechs.studentManagement.dao.AttendanceRecordRepository;
import com.flyingtechs.studentManagement.model.AttendanceRecord;
import com.flyingtechs.studentManagement.service.AttendanceRecordService;
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
public class AttendanceRecordServiceImpl implements AttendanceRecordService {
    private final AttendanceRecordRepository repository;

    public AttendanceRecordServiceImpl(AttendanceRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public AttendanceRecord save(AttendanceRecord entity) {
        return repository.save(entity);
    }

    @Override
    public List<AttendanceRecord> save(List<AttendanceRecord> entities) {
        return (List<AttendanceRecord>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AttendanceRecord> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AttendanceRecord> findAll() {
        return (List<AttendanceRecord>) repository.findAll();
    }

    @Override
    public Page<AttendanceRecord> findAll(Pageable pageable) {
        Page<AttendanceRecord> entityPage = repository.findAll(pageable);
        List<AttendanceRecord> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public AttendanceRecord update(AttendanceRecord entity, Long id) {
        Optional<AttendanceRecord> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}