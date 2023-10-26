package com.flyingtechs.userManagement.service;

import com.flyingtechs.userManagement.model.IdentityDocument;

public interface IdentityDocumentService extends GenericService<IdentityDocument, Long> {

    IdentityDocument update(IdentityDocument entity, Long id);
}