package com.flyingtechs.userManagement.controller.impl;

import com.flyingtechs.userManagement.controller.IdentityDocumentController;
import com.flyingtechs.userManagement.dto.IdentityDocumentDTO;
import com.flyingtechs.userManagement.model.IdentityDocument;
import com.flyingtechs.userManagement.service.IdentityDocumentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/identity-document")
@RestController
public class IdentityDocumentControllerImpl implements IdentityDocumentController {
    private final IdentityDocumentService identityDocumentService;

    public IdentityDocumentControllerImpl(IdentityDocumentService identityDocumentService) {
        this.identityDocumentService = identityDocumentService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IdentityDocumentDTO save(@RequestBody IdentityDocumentDTO identityDocumentDTO) {
        IdentityDocument identityDocument = identityDocumentDTO.toEntity();
        return IdentityDocumentDTO.fromEntity(identityDocumentService.save(identityDocument));
    }

    @Override
    @GetMapping("/{id}")
    public IdentityDocumentDTO findById(@PathVariable("id") Long id) {
        IdentityDocument identityDocument = identityDocumentService.findById(id).orElse(null);
        return IdentityDocumentDTO.fromEntity(identityDocument);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        identityDocumentService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<IdentityDocumentDTO> list() {
        List<IdentityDocument> identityDocuments = identityDocumentService.findAll();
        return identityDocuments.stream().map(IdentityDocumentDTO::fromEntity).collect(Collectors.toList());
    }

    @Override
    @GetMapping("/page-query")
    public Page<IdentityDocumentDTO> pageQuery(Pageable pageable) {
        Page<IdentityDocument> identityDocumentPage = identityDocumentService.findAll(pageable);
        List<IdentityDocumentDTO> dtoList = identityDocumentPage
                .getContent()
                .stream()
                .map(IdentityDocumentDTO::fromEntity)
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, identityDocumentPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public IdentityDocumentDTO update(@RequestBody IdentityDocumentDTO identityDocumentDTO, @PathVariable("id") Long id) {
        IdentityDocument identityDocument = identityDocumentDTO.toEntity();
        return IdentityDocumentDTO.fromEntity(identityDocumentService.update(identityDocument, id));
    }
}