package com.flyingtechs.userManagement.dto;

import com.flyingtechs.userManagement.model.IdentityDocument;

public class IdentityDocumentDTO extends AbstractDTO<Long> {
    private Long id;

    public IdentityDocumentDTO(IdentityDocument identityDocument) {
    }

    public static IdentityDocumentDTO fromEntity(IdentityDocument update) {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public IdentityDocument toEntity() {
        return null;
    }
}