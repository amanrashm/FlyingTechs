package com.flyingtechs.HrManagement.service;

import com.flyingtechs.HrManagement.model.HR;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface HRService {
    public abstract HR save(HR entity);

    public abstract List<HR> save(List<HR> entities);

    public abstract void deleteById(Long id);

    public abstract Optional<HR> findById(Long id);

    public abstract List<HR> findAll();

    public abstract Page<HR> findAll(Pageable pageable);

    public abstract HR update(HR entity, Long id);
}
