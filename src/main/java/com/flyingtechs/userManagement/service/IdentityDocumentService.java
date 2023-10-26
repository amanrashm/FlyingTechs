package com.flyingtechs.userManagement.service;

import com.flyingtechs.userManagement.model.IdentityDocument;
import org.springframework.stereotype.Service;

@Service
public interface IdentityDocumentService extends GenericService<IdentityDocument, Long> {

    IdentityDocument update(IdentityDocument entity, Long id);
}