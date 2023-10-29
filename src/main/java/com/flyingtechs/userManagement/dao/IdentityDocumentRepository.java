package com.flyingtechs.userManagement.dao;

import com.flyingtechs.userManagement.model.IdentityDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentityDocumentRepository extends JpaRepository<IdentityDocument, Long> {
}