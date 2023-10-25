package com.flyingtechs.TestManagement.service;

import com.flyingtechs.TestManagement.model.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TestService {
    public abstract com.flyingtechs.TestManagement.model.Test save(com.flyingtechs.TestManagement.model.Test entity);

    public abstract List<com.flyingtechs.TestManagement.model.Test> save(List<com.flyingtechs.TestManagement.model.Test> entities);

    public abstract void deleteById(Long id);

    public abstract Optional<com.flyingtechs.TestManagement.model.Test> findById(Long id);

    List<Test> findAll();

    public abstract Page<com.flyingtechs.TestManagement.model.Test> findAll(Pageable pageable);

    public abstract com.flyingtechs.TestManagement.model.Test update(com.flyingtechs.TestManagement.model.Test entity, Long id);
}
