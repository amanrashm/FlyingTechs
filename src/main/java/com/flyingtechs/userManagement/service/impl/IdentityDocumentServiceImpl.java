package com.flyingtechs.userManagement.service.impl;

import com.flyingtechs.userManagement.dao.IdentityDocumentRepository;
import com.flyingtechs.userManagement.model.IdentityDocument;
import com.flyingtechs.userManagement.service.IdentityDocumentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public abstract class IdentityDocumentServiceImpl implements IdentityDocumentService {
    private final IdentityDocumentRepository repository;

    public IdentityDocumentServiceImpl(IdentityDocumentRepository repository) {
        this.repository = repository;
    }

    @Override
    public IdentityDocument save(IdentityDocument entity) {
        return repository.save(entity);
    }

    @Override
    public List<IdentityDocument> save(List<IdentityDocument> entities) {
        return (List<IdentityDocument>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<IdentityDocument> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<IdentityDocument> findAll() {
        return (List<IdentityDocument>) repository.findAll();
    }

    @Override
    public Page<IdentityDocument> findAll(Pageable pageable) {
        Page<IdentityDocument> entityPage = repository.findAll(pageable);
        List<IdentityDocument> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    /**
     * @param entity
     * @param id
     * @return
     */
    /*@Override
    public IdentityDocument update(IdentityDocument entity, I id) {
        return null;
    }*/


    @Override
    public IdentityDocument update(IdentityDocument entity, Long id) {
        Optional<IdentityDocument> optional = findById(id) ;
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}