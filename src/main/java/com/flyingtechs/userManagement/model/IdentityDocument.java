package com.flyingtechs.userManagement.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "identity_document")
public class IdentityDocument {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

}